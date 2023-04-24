package com.lancesoft.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lancesoft.dao.ProjectsDao;
import com.lancesoft.dao.WhitePaperDao;

@Service
public class ProjectsServiceImpl implements ProjectsServic {
	@Autowired
	ProjectsDao projectsDao;
	@Autowired
	WhitePaperDao whitePaperDao;
	@Autowired
	HttpServletResponse httpServletResponse;
	@Override
	public ResponseEntity<byte[]> whitepaper(String projects) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
		httpServletResponse.setContentType("application/pdf");
		
		return new ResponseEntity<byte[]>(whitePaperDao.findByName(projects).getPdf(),headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<byte[]> CaseStudy(String caseStudy) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
		httpServletResponse.setContentType("application/pdf");
		return new ResponseEntity<byte[]>(whitePaperDao.findByName(caseStudy).getPdf(), header,HttpStatus.OK);
	}
}
