package lab06_futebolapi.api.controller;

import lab06_futebolapi.domain.model.Time;
import lab06_futebolapi.domain.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService service;

    @Autowired
    public TimeController(TimeService timeService) {
        this.service = timeService;
    }

    @GetMapping
    public List<Time> listar() {
        return service.listarTimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Integer id) {
        Optional<Time> optionalTime = service.buscarPorId(id);

        if (optionalTime.isPresent()) {
            return ResponseEntity.ok(optionalTime.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time cadastrar(@RequestBody Time time) {
        return service.cadastrarTime(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Integer id, @RequestBody Time time) {
        if (!service.existeTime(id)) {
            return ResponseEntity.notFound().build();
        }

        time.setId(id);
        Time timeAtualizado = service.atualizarTime(time);
        return ResponseEntity.ok(timeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (!service.existeTime(id)) {
            return ResponseEntity.notFound().build();
        }

        service.removerTime(id);
        return ResponseEntity.noContent().build();
    }
}
