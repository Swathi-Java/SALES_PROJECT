package com.lancesoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.Whitepaper;

public interface WhitePaperDao extends JpaRepository<Whitepaper, String> {
	public Whitepaper findByName(String name);
}
