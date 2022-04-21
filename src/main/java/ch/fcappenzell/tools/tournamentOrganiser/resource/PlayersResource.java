package ch.fcappenzell.tools.tournamentOrganiser.resource;

import ch.fcappenzell.tools.tournamentOrganiser.model.response.Response;
import ch.fcappenzell.tools.tournamentOrganiser.model.team.Player;
import ch.fcappenzell.tools.tournamentOrganiser.service.PlayersService;
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
@RequestMapping("/players")
@RequiredArgsConstructor
@Slf4j
public class PlayersResource {
    private final PlayersService playersService;

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
                            .data(Map.of("players", playersService.list()))
                            .message("Players retrieved")
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
                            .data(Map.of("deleted", playersService.get(id)))
                            .message("Player deleted")
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
    public ResponseEntity<Response> createTeam(@RequestBody @Valid Player player) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("player", playersService.create(player)))
                            .message("Player created")
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
    public ResponseEntity<Response> updateTeam(@RequestBody @Valid Player player) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("player", playersService.update(player)))
                            .message("Player updated")
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
                            .data(Map.of("deleted", playersService.delete(id)))
                            .message("Player deleted")
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
