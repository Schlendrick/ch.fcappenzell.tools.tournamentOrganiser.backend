package ch.fcappenzell.tools.tournamentOrganiser.model.round;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

public class Category implements Serializable {
    public String id;
    @Column(unique = true)
    @NotEmpty(message = "Category name cannot be empty or null")
    public String name;
    public String description;
    private Color color;
    public List<Team> teams;
}
