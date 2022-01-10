package ch.fcappenzell.tools.tournamentOrganiser.model.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.AUTO;

public class TournamentDay implements Serializable {
    private Long id;
    private LocalDate day;
    private LocalTime startTime;
    private Duration matchTime;
    private Duration breakTime;
    private Duration breakTimeFinals;

}
