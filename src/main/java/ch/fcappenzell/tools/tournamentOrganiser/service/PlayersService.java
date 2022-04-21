package ch.fcappenzell.tools.tournamentOrganiser.service;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Player;
import ch.fcappenzell.tools.tournamentOrganiser.repo.PlayerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PlayersService {
    private final PlayerRepo playerRepo;

    public List<Player> list() throws Exception {
        log.info("Fetching all players");
        return playerRepo.findAll();
    }

    public Player get(Long id) throws Exception {
        log.info("Fetching player by id: {}", id);
        return playerRepo.findById(id).get();
    }

    public Player create(Player player) throws Exception {
        log.info("Saving new Player: {} {}", player.getFirstName(), player.getLastName());
        return playerRepo.save(player);
    }

    public Player update(Player player) throws Exception {
        log.info("Updating player: {} {}", player.getFirstName(), player.getLastName());
        return playerRepo.save(player);
    }

    public Boolean delete(Long id) throws Exception{
        log.info("Deleting player by ID: {}", id);
        playerRepo.deleteById(id);
        return TRUE;
    }

}
