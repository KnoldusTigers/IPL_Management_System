package com.dao;

import com.model.PlayersModel;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface PlayerRepo extends CrudRepository<PlayersModel, Integer> {

 //@Query(value = "select player_name from players  where players.team_id=team.team_id", nativeQuery = true)
//
  List<PlayersModel> findByTeamId(String team_id);
 //  public List<PlayersModel> getAllPlayers();

}
