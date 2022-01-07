package ch.fcappenzell.tools.tournamentOrganiser.model.team;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String category;
    @OneToOne(cascade = {CascadeType.ALL})
    private Captain captain;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Player> players;
    @Column(nullable = false, updatable = false)
    private String uuid;

    public Team(){}

    public Team(Long id, String name, String category, Captain captain, List<Player> players, String uuid) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.captain = captain;
        this.players = players;
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}