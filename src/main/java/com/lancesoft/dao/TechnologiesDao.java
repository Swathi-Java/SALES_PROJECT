package com.lancesoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lancesoft.entity.Technologies;

@Repository
public interface TechnologiesDao extends JpaRepository<Technologies, String> {
public Technologies findByTechid(String techid);
}
