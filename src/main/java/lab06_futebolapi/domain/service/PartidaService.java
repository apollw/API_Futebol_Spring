package lab06_futebolapi.domain.service;

import lab06_futebolapi.domain.model.Partida;
import lab06_futebolapi.domain.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    @Autowired
    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }

    public Optional<Partida> buscarPartidaPorId(Integer id) {
        return partidaRepository.findById(id);
    }

    public Partida cadastrarPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida atualizarPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public void removerPartida(Integer id) {
        partidaRepository.deleteById(id);
    }

    public boolean verificarPartidaExistente(Integer id) {
        return partidaRepository.existsById(id);
    }
}
