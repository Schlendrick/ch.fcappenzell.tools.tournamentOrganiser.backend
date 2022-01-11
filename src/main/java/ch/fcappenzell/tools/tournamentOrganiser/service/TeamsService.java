package ch.fcappenzell.tools.tournamentOrganiser.service;

import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import ch.fcappenzell.tools.tournamentOrganiser.repo.TeamRepo;
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
public class TeamsService {
    private final TeamRepo teamRepo;

    public List<Team> list() {
        log.info("Fetching all teams");
        return teamRepo.findAll();
    }

    public Team get(Long id) {
        log.info("Fetching team by id: {}", id);
        return teamRepo.findById(id).get();
    }

    public Team create(Team team) {
        log.info("Saving new Team: {}", team.getName());
        return teamRepo.save(team);
    }

    public Team update(Team team) {
        log.info("Updating team: {}", team.getName());
        return teamRepo.save(team);
    }

    public Boolean delete(Long id){
        log.info("Deleting team by ID: {}", id);
        teamRepo.deleteById(id);
        return TRUE;
    }

}
