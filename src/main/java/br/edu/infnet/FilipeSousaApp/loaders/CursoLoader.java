package br.edu.infnet.FilipeSousaApp.loaders;

import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.service.CursoService;
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
import java.util.UUID;

@Order(3)
@Component
public class CursoLoader implements ApplicationRunner {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private InstrutorService instrutorService;

    @Override
    public void run(ApplicationArguments args) {
        if (cursoService.obterLista().iterator().hasNext()) {
            System.out.println("✅ Cursos já foram carregados.");
            return;
        }
        System.out.println("🚀 Executando o CursoLoader...");
        var resource = new ClassPathResource("dados/cursos.csv");
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(";");
                if (campos.length < 7) continue;

                Integer instrutorId = Integer.parseInt(campos[5].trim());
                Instrutor instrutor = instrutorService.obterPorId(instrutorId)
                        .orElseThrow(() -> new RuntimeException("ERRO: Instrutor com ID " + instrutorId + " não existe."));

                Curso.NivelCurso nivel = Curso.NivelCurso.valueOf(campos[3].trim().toUpperCase().replace("Á", "A").replace("É", "E"));
                boolean status = Boolean.parseBoolean(campos[4].trim());

                Curso curso = new Curso(
                        campos[0],
                        campos[1],
                        Double.parseDouble(campos[2]),
                        nivel,
                        status,
                        instrutor
                );

                UUID id = UUID.fromString(campos[6].trim());
                curso.setId(id);

                cursoService.incluir(curso);
            }
            System.out.println("✅ Carga de cursos concluída.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o arquivo de cursos: " + e.getMessage());
        }
    }
}