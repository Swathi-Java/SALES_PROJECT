package com.lancesoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.Projects;

public interface ProjectsDao extends JpaRepository<Projects, String> {
  public Projects findByName(String name); 
}
