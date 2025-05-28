package br.edu.infnet.FilipeSousaApp.model.loaders;

import br.edu.infnet.FilipeSousaApp.model.domain.Aula;
import br.edu.infnet.FilipeSousaApp.model.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Order(5)
@Component
public class AulaLoader implements ApplicationRunner {
    @Autowired
    private AulaService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("🚀 AulaTest executando...");
        try{
            FileReader arquivo = new FileReader("aulas.csv");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();
            linha = lerArquivo.readLine();
            String[] campos = null;
            while(linha != null){
                campos = linha.split(",");
                Aula aula = new Aula(
                        campos[0],
                        campos[1],
                        campos[2],
                        Boolean.parseBoolean(campos[3])
                );
                service.incluir(aula);
                linha = lerArquivo.readLine();
            }
            for(Aula aula: service.obterLista())
            {
                System.out.println(aula);
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
