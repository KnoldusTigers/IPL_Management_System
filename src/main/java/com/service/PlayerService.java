package com.service;

import com.dao.PlayerRepo;
import com.model.PlayersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo prepo;
//    public List<PlayersModel> getAllPlayers(){
////        System.out.println(getPlayers());
//         return (List<PlayersModel>) prepo.findAll();
//    }
    public void save(final PlayersModel player_model) {

        prepo.save(player_model);
    }
    public PlayersModel get(String Id) {

        return prepo.findById(Integer.valueOf(Id)).get();
    }


    public void delete(int id) {

        prepo.deleteById(id);
    }

}


