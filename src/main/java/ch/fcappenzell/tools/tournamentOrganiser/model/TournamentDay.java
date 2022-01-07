package ch.fcappenzell.tools.tournamentOrganiser.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TournamentDay {

    private long id;
    private LocalDate day;
    private LocalTime startTime;
    private Duration matchTime;
    private Duration breakTime;
    private Duration breakTimeFinals;

}
