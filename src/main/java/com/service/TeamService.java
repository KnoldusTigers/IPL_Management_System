package com.service;
import com.dao.TeamRepo;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * The type Team service.
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepo repo;

    /**
     * List all list.
     *
     * @return the list
     */
    public List<TeamModel> listAll() {

        return repo.findAll();
    }

    /**
     * Save.
     *
     * @param Teams the teams
     */
    public void save(TeamModel Teams) {

        repo.save(Teams);
    }

    /**
     * Get team model.
     *
     * @param Id the id
     * @return the team model
     */
    public TeamModel get(Long Id) {

        return repo.findById((Id)).get();
    }

    /**
     * Find byname optional.
     *
     * @param teamname the teamname
     * @return the optional
     */
    @Transactional
    public Optional<TeamModel> findByname(String teamname) {
        return repo.findByTeamname(teamname);
    }

    /**
     * Team name exists boolean.
     *
     * @param teamname the teamname
     * @return the boolean
     */
    public boolean teamNameExists(String teamname){
        return findByname(teamname).isPresent();
    }
}
