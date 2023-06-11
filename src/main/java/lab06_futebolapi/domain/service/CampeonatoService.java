package lab06_futebolapi.domain.service;

import lab06_futebolapi.domain.model.Campeonato;
import lab06_futebolapi.domain.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository repository;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.repository = campeonatoRepository;
    }

    public List<Campeonato> listarCampeonatos() {
        return repository.findAll();
    }

    public Optional<Campeonato> buscarCampeonatoPorId(Integer id) {
        return repository.findById(id);
    }

    public Campeonato cadastrarCampeonato(Campeonato campeonato) {
        return repository.save(campeonato);
    }

    public Campeonato atualizarCampeonato(Campeonato campeonato) {
        return repository.save(campeonato);
    }

    public void removerCampeonato(Integer id) {
        repository.deleteById(id);
    }

    public boolean verificarCampeonatoExistente(Integer id) {
        return repository.existsById(id);
    }
}
