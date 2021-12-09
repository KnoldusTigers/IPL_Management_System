package com.dao;

import com.model.PointModel;
import com.service.resultservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepo extends JpaRepository<PointModel,Long> {

    PointModel findByTeamId(Long id);
}
