package ch.fcappenzell.tools.tournamentOrganiser.model.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Team name cannot be empty or null")
    private String name;
    private String category;
    @OneToOne(cascade = {CascadeType.ALL})
    private Captain captain;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Player> players;
    @Column(nullable = false, updatable = false)
    private String uuid;

}