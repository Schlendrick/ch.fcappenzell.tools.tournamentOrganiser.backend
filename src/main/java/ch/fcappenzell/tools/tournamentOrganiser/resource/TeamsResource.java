package ch.fcappenzell.tools.tournamentOrganiser.resource;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import ch.fcappenzell.tools.tournamentOrganiser.service.TeamsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamsResource {
    private final TeamsService teamsService;

    public TeamsResource(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamsService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team newTeam = teamsService.addTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

}
