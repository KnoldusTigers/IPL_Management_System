package com.dao;

import com.model.MatchModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchRepo extends CrudRepository<MatchModel, Integer> {
    //    List<PlayersModel> findByTeamId(String team_id);
    Optional<MatchModel> findByVenue(String venue);
    Optional<MatchModel> findByScheduledate(String date);
}
