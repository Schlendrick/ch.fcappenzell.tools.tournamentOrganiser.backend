package ch.fcappenzell.tools.tournamentOrganiser.repo;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    void deletePlayerById(Long id);

    Optional<Player> findPlayerById(Long id);
}

