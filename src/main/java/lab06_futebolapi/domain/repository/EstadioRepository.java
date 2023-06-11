package lab06_futebolapi.domain.repository;

import lab06_futebolapi.domain.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer> {
    List<Estadio> findByNomeContaining(String nome );
}
