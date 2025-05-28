package br.edu.infnet.FilipeSousaApp.model.loaders;
import br.edu.infnet.FilipeSousaApp.model.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.model.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@Order(4)
@Component
public class EstudanteLoader implements ApplicationRunner {

    @Autowired
    EstudanteService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            System.out.println("🚀EstudanteTeste executando...");
            FileReader arquivo = new FileReader("estudantes.csv");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String linha = lerArquivo.readLine();
            linha = lerArquivo.readLine();
            String[] campos = null;
            while(linha != null){
                campos = linha.split(",");
                Estudante estudante = new Estudante(campos[1], campos[2], campos[3], campos[4], new ArrayList<>());
                service.incluir(estudante);
                linha = lerArquivo.readLine();
            }

            for(Estudante estudante: service.obterLista())
            {
                System.out.println(estudante);
            }
            lerArquivo.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }catch(IOException e) {
            System.out.println("Erro ao carregar arquivo!");
            e.printStackTrace();
        }
    }
}
