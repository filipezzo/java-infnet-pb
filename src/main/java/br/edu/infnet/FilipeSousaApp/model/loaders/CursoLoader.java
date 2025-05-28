package br.edu.infnet.FilipeSousaApp.model.loaders;

import br.edu.infnet.FilipeSousaApp.model.domain.Curso;
import br.edu.infnet.FilipeSousaApp.model.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Order(3)
@Component
public class CursoLoader implements ApplicationRunner {

    @Autowired
    private CursoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            System.out.println("🚀 CursoTest executando...");
            FileReader arquivo = new FileReader("cursos.csv");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();
            linha = lerArquivo.readLine();
            String[] campos = null;
            while(linha != null){
                campos = linha.split(",");
                Curso curso = new Curso(
                        campos[0],
                        campos[1],
                        Double.parseDouble(campos[2]),
                        campos[3],
                        campos[4]
                );
                service.incluir(curso);
                linha = lerArquivo.readLine();
            }
            for(Curso curso: service.obterLista())
            {
                System.out.println(curso);
            }
            lerArquivo.close();
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        }catch(IOException e) {
            System.out.println("Erro ao carregar arquivo!");
        }
    }
}
