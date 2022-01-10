package ch.fcappenzell.tools.tournamentOrganiser.model.tournament;

import java.io.Serializable;
import java.util.List;

public class Tournament implements Serializable {

    private String name;
    private Long fields;
    private List<TournamentDay> tournamentDays;

}
