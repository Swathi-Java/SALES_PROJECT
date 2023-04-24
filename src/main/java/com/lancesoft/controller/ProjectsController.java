package com.lancesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancesoft.service.ProjectsServiceImpl;

@RestController
@CrossOrigin("*")
public class ProjectsController {
	@Autowired
	ProjectsServiceImpl projectsServiceImpl;
	@GetMapping("/Whitepaper")
	public ResponseEntity<byte []> projectspdf(@RequestParam String projects)
	{
		return projectsServiceImpl.whitepaper(projects);
	}
	@GetMapping("/CaseStudy")
	
	public ResponseEntity<byte []> projectpdf(@RequestParam String projects)
	{
		return projectsServiceImpl.CaseStudy(projects);
	}
}
