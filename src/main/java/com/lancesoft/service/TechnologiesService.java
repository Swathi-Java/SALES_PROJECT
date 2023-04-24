package com.lancesoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;

@Service
public interface TechnologiesService {
	public List<Technologies> gettechnology();
	public List<TechnologyResponse> techdetails();
}
