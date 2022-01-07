package ch.fcappenzell.tools.tournamentOrganiser.model.team;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private Date birthday ;
    private Boolean clubPlayer;

    public Player(){}

    public Player(Long id, String title, String firstName, String lastName, Date birthday, Boolean clubPlayer) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.clubPlayer = clubPlayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getClubPlayer() {
        return clubPlayer;
    }

    public void setClubPlayer(Boolean clubPlayer) {
        this.clubPlayer = clubPlayer;
    }
}
