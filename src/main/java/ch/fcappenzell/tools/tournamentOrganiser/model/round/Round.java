package ch.fcappenzell.tools.tournamentOrganiser.model.round;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private String code;
    private String bookName;
    private Arrangement arrangement;
    private List<Holding> holdings = new ArrayList<>();
}
