package com.service;


import com.dao.MatchRepo;
import com.model.MatchModel;
import com.model.PlayersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    public List<MatchModel> getAllMatches(){
//        System.out.println(getPlayers());
         return (List<MatchModel>) matchRepo.findAll();
    }

    public void save(MatchModel match_model){

        matchRepo.save(match_model);
    }
    public MatchModel get(String Id){

        return matchRepo.findById(Id).get();
    }


    public void delete(String id) {

        matchRepo.deleteById(id);
    }


}
