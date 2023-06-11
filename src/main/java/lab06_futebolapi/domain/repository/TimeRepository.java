package lab06_futebolapi.domain.repository;

import lab06_futebolapi.domain.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
    List<Time> findByNomeContaining(String nome );
}
