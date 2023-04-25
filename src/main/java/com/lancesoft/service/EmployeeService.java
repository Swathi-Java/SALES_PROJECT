package com.lancesoft.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lancesoft.entity.Count;
import com.lancesoft.entity.Employee;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.ProjectNames;

@Service
public interface EmployeeService {
	public HashSet<EmployeeResponse> getManager(String techid);

	public Count count(String techid,String managerid,String empid);
	public ResponseEntity<byte[]> gettimages(String empid);
	public List<EmployeeResponse> employcount(@RequestParam String techid, @RequestParam String managerid);
	public  HashSet<Proj> projectCount(@RequestParam String techid, @RequestParam String empid);
}
