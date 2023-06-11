package lab06_futebolapi.api.controller;

import lab06_futebolapi.domain.model.Jogador;
import lab06_futebolapi.domain.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.service = jogadorService;
    }

    // versao 01
    @GetMapping
    public List<Jogador> lista(String nome ) {
        if (nome == null ) {
            return service.todos();
        } else {
            return service.buscaPor(nome );
        }
    }

    //versao 01
    @GetMapping("/{id}")
    public Jogador buscaPor(@PathVariable Integer id ) {
        return service.buscaPor(id ).orElse(null);
    }

    //versao 02
    @GetMapping("v2/{id}")
    public ResponseEntity<Jogador> buscaPorV2(@PathVariable Integer id) {
        Optional<Jogador> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("v3/{id}")
    public ResponseEntity<Jogador> buscaPorV3(@PathVariable Integer id) {
        return service.buscaPor(id)
                .map(ResponseEntity::ok )   //.map(jogador -> ResponseEntity.ok(jogador))
                .orElse(ResponseEntity.notFound().build());

    }

    // versão 01
    @PostMapping
    public Jogador cadastrar(@RequestBody Jogador jogador ) {
        return service.salva(jogador );
    }

    @PostMapping("/v2")
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador cadastrarv2(@RequestBody Jogador jogador ) {
        return service.salva(jogador );
    }

    @PostMapping("/v3")
    public ResponseEntity<Jogador> cadastrov3(@RequestBody Jogador jogador, UriComponentsBuilder builder ) {

        final Jogador jogadorSalvo = service.salva(jogador);

        final URI uri = builder
                .path("/jogadores/{id}")
                .buildAndExpand(jogadorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(jogadorSalvo );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualiza(@PathVariable Integer id, @RequestBody Jogador jogador) {

        if (service.naoExisteJogadorCom(id ) ) {
            return ResponseEntity.notFound().build();

        } else {
            jogador.setId(id);
            Jogador jogadorAtualizado = service.salva(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Jogador> optional = service.buscaPor(id );

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
