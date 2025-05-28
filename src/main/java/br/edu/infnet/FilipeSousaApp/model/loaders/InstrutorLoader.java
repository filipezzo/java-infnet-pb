package br.edu.infnet.FilipeSousaApp.model.loaders;
import br.edu.infnet.FilipeSousaApp.model.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.model.services.InstrutorService;
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

@Order(2)
@Component
public class InstrutorLoader implements ApplicationRunner {

    @Autowired
    private InstrutorService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("🚀 InstrutorTest executando...");
        try{
            FileReader arquivo = new FileReader("instrutores.csv");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();
            linha = lerArquivo.readLine();
            String[] campos = null;
            while(linha != null){
                campos = linha.split(",");
                Instrutor instrutor = new Instrutor(
                        campos[1],
                        campos[2],
                        campos[3],
                        campos[4],
                        campos[5],
                        Boolean.parseBoolean(campos[6]),
                        new ArrayList<>()
                );
                service.incluir(instrutor);
                linha = lerArquivo.readLine();
            }
            for(Instrutor instrutor: service.obterLista()){
                System.out.println(instrutor);
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

