package com.dao;

import com.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<TeamModel, Long> {


}
