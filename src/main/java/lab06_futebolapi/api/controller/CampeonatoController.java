package lab06_futebolapi.api.controller;

import lab06_futebolapi.domain.model.Campeonato;
import lab06_futebolapi.domain.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService service;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService) {
        this.service = campeonatoService;
    }

    @GetMapping
    public List<Campeonato> listarCampeonatos() {
        return service.listarCampeonatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> buscarCampeonatoPorId(@PathVariable Integer id) {
        Optional<Campeonato> optional = service.buscarCampeonatoPorId(id);

        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Campeonato cadastrarCampeonato(@RequestBody Campeonato campeonato) {
        return service.cadastrarCampeonato(campeonato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> atualizarCampeonato(@PathVariable Integer id, @RequestBody Campeonato campeonato) {
        if (!service.verificarCampeonatoExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        campeonato.setId(id);
        Campeonato campeonatoAtualizado = service.atualizarCampeonato(campeonato);
        return ResponseEntity.ok(campeonatoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerCampeonato(@PathVariable Integer id) {
        if (!service.verificarCampeonatoExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        service.removerCampeonato(id);
        return ResponseEntity.noContent().build();
    }
}
