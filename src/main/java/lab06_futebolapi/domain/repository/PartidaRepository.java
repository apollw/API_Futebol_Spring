package lab06_futebolapi.domain.repository;

import lab06_futebolapi.domain.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
}
