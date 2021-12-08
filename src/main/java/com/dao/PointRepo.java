package com.dao;

import com.model.PointModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepo extends JpaRepository<PointModel,Long> {
}
