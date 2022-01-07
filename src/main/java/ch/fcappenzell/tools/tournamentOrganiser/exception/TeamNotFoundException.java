package ch.fcappenzell.tools.tournamentOrganiser.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        super(message);
    }
}