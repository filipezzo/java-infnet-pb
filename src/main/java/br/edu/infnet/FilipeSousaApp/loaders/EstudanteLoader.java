package br.edu.infnet.FilipeSousaApp.loaders;

import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.service.CursoService;
import br.edu.infnet.FilipeSousaApp.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Order(4)
@Component
public class EstudanteLoader implements ApplicationRunner {

    @Autowired
    private EstudanteService estudanteService;
    @Autowired
    private CursoService cursoService;

    @Override
    public void run(ApplicationArguments args) {
        if (estudanteService.obterLista().iterator().hasNext()) {
            System.out.println("✅ Estudantes já foram carregados.");
            return;
        }
        System.out.println("🚀 Executando o EstudanteLoader...");
        var resource = new ClassPathResource("dados/estudantes.csv");
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(";");
                if (campos.length < 5) continue;

                Estudante estudante = new Estudante(
                        campos[0],
                        campos[1],
                        campos[2],
                        campos[3]
                );

                String[] cursosIds = campos[4].split(":");
                List<Curso> cursosMatriculados = new ArrayList<>();
                for (String idStr : cursosIds) {
                    if (idStr == null || idStr.trim().isEmpty()) continue;
                    UUID cursoId = UUID.fromString(idStr.trim());
                    cursoService.obterPorId(cursoId).ifPresent(cursosMatriculados::add);
                }
                estudante.setCursos(cursosMatriculados);

                estudanteService.incluir(estudante);
            }
            estudanteService.imprimirListaCompleta();
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o arquivo de estudantes: " + e.getMessage());
        }
    }
}