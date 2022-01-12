package ch.fcappenzell.tools.tournamentOrganiser.model.team;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "captain")
@AllArgsConstructor
@NoArgsConstructor
public class Captain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @NotNull
    @Size(max = 25)
    private String title;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String street;

    @NotNull
    private Long plz;

    @NotNull
    @Size(max = 50)
    private String place;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    private String phone;

}
