package br.edu.infnet.FilipeSousaApp.loaders;

import br.edu.infnet.FilipeSousaApp.domain.Aula;
import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.service.AulaService;
import br.edu.infnet.FilipeSousaApp.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

@Order(5)
@Component
public class AulaLoader implements ApplicationRunner {

    @Autowired
    private AulaService aulaService;
    @Autowired
    private CursoService cursoService;

    @Override
    public void run(ApplicationArguments args) {
        if (aulaService.obterLista().iterator().hasNext()) {
            System.out.println("✅ Aulas já foram carregadas.");
            return;
        }
        System.out.println("🚀 Executando o AulaLoader...");
        var resource = new ClassPathResource("dados/aulas.csv");
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(";");
                if (campos.length < 5) continue;

                UUID cursoId = UUID.fromString(campos[4].trim());
                Curso curso = cursoService.obterPorId(cursoId)
                        .orElseThrow(() -> new RuntimeException("ERRO: Curso com ID " + cursoId + " não existe."));
                Aula aula = new Aula(
                        campos[0],
                        campos[1],
                        campos[2].replace("\"", ""),
                        Boolean.parseBoolean(campos[3]),
                        curso
                );
                aulaService.incluir(aula);
            }
            System.out.println("✅ Carga de aulas concluída.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o arquivo de aulas: " + e.getMessage());
        }
    }
}