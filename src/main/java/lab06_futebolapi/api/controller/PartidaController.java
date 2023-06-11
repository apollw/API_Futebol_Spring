package lab06_futebolapi.api.controller;

import lab06_futebolapi.domain.model.Partida;
import lab06_futebolapi.domain.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable Integer id) {
        Optional<Partida> partida = partidaService.buscarPartidaPorId(id);
        return partida.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Partida cadastrarPartida(@RequestBody Partida partida) {
        return partidaService.cadastrarPartida(partida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> atualizarPartida(@PathVariable Integer id, @RequestBody Partida partida) {
        if (!partidaService.verificarPartidaExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        partida.setId(id);
        Partida partidaAtualizada = partidaService.atualizarPartida(partida);
        return ResponseEntity.ok(partidaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPartida(@PathVariable Integer id) {
        if (!partidaService.verificarPartidaExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        partidaService.removerPartida(id);
        return ResponseEntity.noContent().build();
    }
}
