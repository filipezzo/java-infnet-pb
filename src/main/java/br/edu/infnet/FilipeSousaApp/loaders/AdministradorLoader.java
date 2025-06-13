package br.edu.infnet.FilipeSousaApp.loaders;

import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Order(1)
@Component
public class AdministradorLoader implements ApplicationRunner {

    @Autowired
    private AdministradorService administradorService;

    @Override
    public void run(ApplicationArguments args) {
        if (administradorService.obterLista().iterator().hasNext()) {
            System.out.println("✅ Administradores já foram carregados.");
            return;
        }
        System.out.println("🚀 Executando o AdministradorLoader...");
        var resource = new ClassPathResource("dados/administradores.csv");
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(";");
                if (campos.length < 5) continue;

                Administrador.NivelAcesso nivelAcesso = Administrador.NivelAcesso.valueOf(campos[4].toUpperCase().trim());
                Administrador administrador = new Administrador(
                        campos[0],
                        campos[1],
                        campos[2],
                        campos[3],
                        nivelAcesso
                );
                administradorService.incluir(administrador);
            }
            System.out.println("✅ Carga de administradores concluída.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao processar o arquivo administradores.csv: " + e.getMessage());
        }
    }
}