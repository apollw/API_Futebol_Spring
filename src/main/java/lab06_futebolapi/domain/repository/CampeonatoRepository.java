package lab06_futebolapi.domain.repository;

import lab06_futebolapi.domain.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
    List<Campeonato> findByNomeContaining(String nome );
}
