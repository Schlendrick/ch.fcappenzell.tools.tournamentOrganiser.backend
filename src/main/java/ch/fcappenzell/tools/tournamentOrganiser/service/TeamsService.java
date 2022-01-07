package ch.fcappenzell.tools.tournamentOrganiser.service;

import ch.fcappenzell.tools.tournamentOrganiser.exception.TeamNotFoundException;
import ch.fcappenzell.tools.tournamentOrganiser.model.team.Team;
import ch.fcappenzell.tools.tournamentOrganiser.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TeamsService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamsService(TeamRepo employeeRepo) {
        this.teamRepo = employeeRepo;
    }

    public Team addTeam(Team team) {
        team.setUuid(UUID.randomUUID().toString());
        return teamRepo.save(team);
    }

    public List<Team> findAll() {
        return teamRepo.findAll();
    }

    public Team updateEmployee(Team team) {
        return teamRepo.save(team);
    }

    public Team findTeamById(Long id) {
        return teamRepo.findTeamById(id).orElseThrow(() -> new TeamNotFoundException("Team by id " + id + " was not found"));
    }

    public void deletePlayer(Long id){
        teamRepo.deleteTeamById(id);
    }
}
