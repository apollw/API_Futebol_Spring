package lab06_futebolapi.domain.service;

import lab06_futebolapi.domain.model.Jogador;
import lab06_futebolapi.domain.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private final JogadorRepository repository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.repository = jogadorRepository;
    }

    public List<Jogador> todos() {
        return repository.findAll();
    }

    public Optional<Jogador> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public List<Jogador> buscaPor(String nome) {
        return repository.findByNomeContaining(nome );
    }

    @Transactional
    public Jogador salva(Jogador jogador) {
        return repository.save(jogador);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteJogadorCom(Integer id ) {
        return !repository.existsById(id );
    }

}
