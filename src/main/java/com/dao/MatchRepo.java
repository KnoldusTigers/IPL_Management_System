package com.dao;

import com.model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchRepo extends JpaRepository<MatchModel,String> {


}
