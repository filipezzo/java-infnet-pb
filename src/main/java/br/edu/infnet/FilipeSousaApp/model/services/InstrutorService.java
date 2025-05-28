package br.edu.infnet.FilipeSousaApp.model.services;
import br.edu.infnet.FilipeSousaApp.model.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.model.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.model.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstrutorService {
    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor incluir(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public Iterable<Instrutor> obterLista() {
        return instrutorRepository.findAll();
    }
}
