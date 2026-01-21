package com.razib.springboot.project.springBootProject.Dao;

import com.razib.springboot.project.springBootProject.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchDao extends JpaRepository<Batch,Integer> {
    Batch getById(Integer batchId);
}
