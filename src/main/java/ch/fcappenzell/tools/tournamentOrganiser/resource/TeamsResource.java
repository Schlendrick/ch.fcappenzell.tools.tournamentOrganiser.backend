package ch.fcappenzell.tools.tournamentOrganiser.resource;

import ch.fcappenzell.tools.tournamentOrganiser.model.response.Response;
import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import ch.fcappenzell.tools.tournamentOrganiser.service.TeamsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.core.NestedExceptionUtils.getRootCause;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamsResource {
    private final TeamsService teamsService;

    public ResponseEntity<Response> handleExceptions(Exception e) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message(getRootCause(e).getMessage())
                        .status(BAD_REQUEST)
                        .statusCode(BAD_REQUEST.value())
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listTeams() {
        try {
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
        catch(Exception e) {
            return handleExceptions(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getTeam(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("deleted", teamsService.get(id)))
                            .message("Team deleted")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()
            );
        }
        catch(Exception e) {
            return handleExceptions(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createTeam(@RequestBody @Valid Team team) {
        try {
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
        catch(Exception e) {
            return handleExceptions(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Response> updateTeam(@RequestBody @Valid Team team) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("team", teamsService.update(team)))
                            .message("Team updated")
                            .status(ACCEPTED)
                            .statusCode(ACCEPTED.value())
                            .build()
            );
        }
            catch(Exception e) {
            return handleExceptions(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTeam(@PathVariable("id") Long id) {
        try {
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
        catch(Exception e) {
            return handleExceptions(e);
        }
    }

}
