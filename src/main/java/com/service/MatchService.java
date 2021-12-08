package com.service;


import com.dao.MatchRepo;
import com.model.MatchModel;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    public List<MatchModel> getAllMatches() {
//        System.out.println(getPlayers());

         return (List<MatchModel>) matchRepo.findAll();
    }

    public void save(final MatchModel match_model) {

        matchRepo.save(match_model);
    }
    public MatchModel get(int Id) {

        return matchRepo.findById(Id).get();
    }


    public void delete(int id) {

        matchRepo.deleteById(id);
    }



}
