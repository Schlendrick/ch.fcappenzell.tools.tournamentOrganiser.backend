package ch.fcappenzell.tools.tournamentOrganiser.resource;

import ch.fcappenzell.tools.tournamentOrganiser.model.Response;
import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import ch.fcappenzell.tools.tournamentOrganiser.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamsResource {
    private final TeamsService teamsService;

    @GetMapping("/list")
    public ResponseEntity<Response> listTeams() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("teams", teamsService.list()))
                        .message("Teams retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTeam(@RequestBody @Valid Team team) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("team", teamsService.create(team)))
                        .message("Team created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTeam(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", teamsService.delete(id)))
                        .message("Team deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
