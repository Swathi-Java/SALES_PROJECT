package com.lancesoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lancesoft.entity.Count;
import com.lancesoft.entity.EmployeeResponse;

@Service
public interface EmployeeService {
	public List<EmployeeResponse> getManager(String techid);

	public Count count(String techid,String managerid,String empid);
	public ResponseEntity<byte[]> gettimages(String empid);
}
