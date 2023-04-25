package com.lancesoft.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancesoft.entity.Count;
import com.lancesoft.entity.Employee;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.ProjectNames;
import com.lancesoft.service.EmployeeServiceImpl;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@GetMapping("/getmanager")
	public HashSet<EmployeeResponse> employees(@RequestParam String techid)
	{
	return employeeServiceImpl.getManager(techid);
	}

	@GetMapping("/Count")

	public Count count(@RequestParam String techid, @RequestParam String managerid,@RequestParam String empid)
	{
		return employeeServiceImpl.count(techid, managerid,empid);
	}
	@GetMapping("/image")
	public ResponseEntity<byte[]> employeeimage(@RequestParam String empid) {
		return employeeServiceImpl.gettimages(empid);
	}
	@GetMapping("/employeecount")

	public List<EmployeeResponse> Employcount(@RequestParam String techid, @RequestParam String managerid)
	{
		return employeeServiceImpl.employcount(techid, managerid);
	}
	
	@GetMapping("/projectCount")

	public HashSet<Proj> projectCount(@RequestParam String techid, @RequestParam String empid)
	{
		return employeeServiceImpl.projectCount(techid, empid);
	}
	
}
