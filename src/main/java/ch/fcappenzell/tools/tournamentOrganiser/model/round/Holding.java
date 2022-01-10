package ch.fcappenzell.tools.tournamentOrganiser.model.round;

import java.util.List;

public class Holding {

    private Long id;
    private Long order;
    private String code;
    private String bookName;
    private Round round;
    private List<Match> matches;
}
