package lab06_futebolapi.domain.service;

import lab06_futebolapi.domain.model.Time;
import lab06_futebolapi.domain.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository repository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.repository = timeRepository;
    }

    public List<Time> listarTimes() {
        return repository.findAll();
    }

    public Optional<Time> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Time cadastrarTime(Time time) {
        return repository.save(time);
    }

    @Transactional
    public Time atualizarTime(Time time) {
        return repository.save(time);
    }

    @Transactional
    public void removerTime(Integer id) {
        repository.deleteById(id);
    }

    public boolean existeTime(Integer id) {
        return repository.existsById(id);
    }
}
