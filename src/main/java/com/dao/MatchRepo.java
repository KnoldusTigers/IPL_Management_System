package com.dao;

import com.model.MatchModel;
import com.model.PlayersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;
import java.util.List;


public interface MatchRepo extends CrudRepository<MatchModel,String> {

//    List<PlayersModel> findByTeamId(String team_id);

}
