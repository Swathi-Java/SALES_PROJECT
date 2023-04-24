package com.lancesoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProjectsServic {
	public ResponseEntity<byte[]> whitepaper(String projects);
	public ResponseEntity<byte[]> CaseStudy(String caseStudy) ;
}
