package com.service;
import com.dao.TeamRepo;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepo repo;

    public List<TeamModel> listAll() {

        return repo.findAll();
    }
    public void save(TeamModel Teams) {

        repo.save(Teams);
    }
    public TeamModel get(Long Id) {

        return repo.findById((Id)).get();
    }

}
