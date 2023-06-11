package lab06_futebolapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Campeonato {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private Integer ano;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "campeonato_time",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private List<Time> times = new ArrayList<>();

    @OneToMany(mappedBy = "campeonato")
    private List<Partida> partidas = new ArrayList<>();
}