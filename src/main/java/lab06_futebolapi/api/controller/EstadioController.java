package lab06_futebolapi.api.controller;

import lab06_futebolapi.domain.model.Estadio;
import lab06_futebolapi.domain.service.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioService service;

    @Autowired
    public EstadioController(EstadioService estadioService) {
        this.service = estadioService;
    }

    @GetMapping
    public List<Estadio> listar() {
        return service.listarEstadios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscarPorId(@PathVariable Integer id) {
        Optional<Estadio> optionalEstadio = service.buscarEstadioPorId(id);
        return optionalEstadio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estadio cadastrar(@RequestBody Estadio estadio) {
        return service.cadastrarEstadio(estadio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadio> atualizar(@PathVariable Integer id, @RequestBody Estadio estadio) {
        if (!service.verificarEstadioExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        estadio.setId(id);
        Estadio estadioAtualizado = service.atualizarEstadio(estadio);
        return ResponseEntity.ok(estadioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (!service.verificarEstadioExistente(id)) {
            return ResponseEntity.notFound().build();
        }

        service.removerEstadio(id);
        return ResponseEntity.noContent().build();
    }
}
