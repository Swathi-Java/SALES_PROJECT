package com.lancesoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;
import com.lancesoft.service.TechnologiesServiceImpl;

@RestController
@CrossOrigin("*")
public class TechnologiesController {
	@Autowired
	TechnologiesServiceImpl technologiesServiceImpl;

	@GetMapping("/getallTechnologies")
	public List<Technologies> gettechnologies() {
		return technologiesServiceImpl.gettechnology();
	}

	@GetMapping("/TechnologiesResponse")

	public List<TechnologyResponse> techresponse()

	{

		return technologiesServiceImpl.techdetails();

	}

}
