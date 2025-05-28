package br.edu.infnet.FilipeSousaApp.model.loaders;

import br.edu.infnet.FilipeSousaApp.model.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.model.services.AdministradorService;
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

@Order(1)
@Component
public class AdministradorLoader implements ApplicationRunner {
    @Autowired
    private AdministradorService administradorService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("🚀 AdministradorTest executando...");
        try{
            FileReader arquivo = new FileReader("administradores.csv");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();
            linha = lerArquivo.readLine();
            String[] campos = null;
            while(linha != null){
                campos = linha.split(",");
                Administrador administrador = new Administrador(
                        campos[1],
                        campos[2],
                        campos[3],
                        campos[4],
                        campos[5],
                        campos[6],
                        new ArrayList<>()
                );
                administradorService.incluir(administrador);
                linha = lerArquivo.readLine();
            }
            for(Administrador administrador: administradorService.obterLista()){
                System.out.println(administrador);
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
