package br.edu.infnet.FilipeSousaApp.loaders;

import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.service.AdministradorService;
import br.edu.infnet.FilipeSousaApp.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Order(2)
@Component
public class InstrutorLoader implements ApplicationRunner {

    @Autowired
    private InstrutorService instrutorService;
    @Autowired
    private AdministradorService administradorService;

    @Override
    public void run(ApplicationArguments args) {
        if (instrutorService.obterLista().iterator().hasNext()) {
            System.out.println("✅ Instrutores já foram carregados.");
            return;
        }
        System.out.println("🚀 Executando o InstrutorLoader...");
        var resource = new ClassPathResource("dados/instrutores.csv");
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(";");
                if (campos.length < 6) continue;

                Integer adminId = Integer.parseInt(campos[5].trim());
                Administrador admin = administradorService.obterPorId(adminId)
                        .orElseThrow(() -> new RuntimeException("ERRO: Administrador com ID " + adminId + " não existe."));
                Instrutor instrutor = new Instrutor(
                        campos[0],
                        campos[1],
                        campos[2],
                        campos[3],
                        Boolean.parseBoolean(campos[4]),
                        admin
                );
                instrutorService.incluir(instrutor);
            }
            System.out.println("✅ Carga de instrutores concluída.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o arquivo de instrutores: " + e.getMessage());
        }
    }
}