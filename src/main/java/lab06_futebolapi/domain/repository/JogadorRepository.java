package lab06_futebolapi.domain.repository;

import lab06_futebolapi.domain.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    List<Jogador> findByNomeContaining(String nome );
}
