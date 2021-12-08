package com.dao;

import com.model.MatchModel;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepo extends CrudRepository<MatchModel, Integer> {
//    List<PlayersModel> findByTeamId(String team_id);
}
