package ch.fcappenzell.tools.tournamentOrganiser.repo;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, Long> {
    void deleteTeamById(Long id);

    Optional<Team> findTeamById(Long id);
}

