package lab06_futebolapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Partida {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "time_mandante_id")
    private Time timeMandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time timeVisitante;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

}