package lab06_futebolapi.domain.service;

import lab06_futebolapi.domain.model.Estadio;
import lab06_futebolapi.domain.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    private final EstadioRepository repository;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository) {
        this.repository = estadioRepository;
    }

    public List<Estadio> listarEstadios() {
        return repository.findAll();
    }

    public Optional<Estadio> buscarEstadioPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Estadio cadastrarEstadio(Estadio estadio) {
        return repository.save(estadio);
    }

    @Transactional
    public Estadio atualizarEstadio(Estadio estadio) {
        return repository.save(estadio);
    }

    @Transactional
    public void removerEstadio(Integer id) {
        repository.deleteById(id);
    }

    public boolean verificarEstadioExistente(Integer id) {
        return repository.existsById(id);
    }
}
