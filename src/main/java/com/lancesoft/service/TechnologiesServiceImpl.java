package com.lancesoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancesoft.dao.EmployeeDao;
import com.lancesoft.dao.TechnologiesDao;
import com.lancesoft.entity.Employee;
import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;

@Service
public class TechnologiesServiceImpl implements TechnologiesService {
	@Autowired
	TechnologiesDao technologiesDao;
    @Autowired
    EmployeeDao employeeDao;
	@Override
	public List<Technologies> gettechnology() {

		return technologiesDao.findAll();
	}

	@Override
	public List<TechnologyResponse> techdetails()
	{
	List<Technologies> technologies2=technologiesDao.findAll();
	List<TechnologyResponse>techResponse=new ArrayList<>();
	for(int i=0;i<technologies2.size();i++)
	{
	// Employees employes=new Employees();
	Technologies technologies = technologiesDao.findByTechid(technologies2.get(i).getTechid());
	List<Employee>employee=employeeDao.findBytechlist(technologies);
	TechnologyResponse technologyResponse=new TechnologyResponse();
	technologyResponse.setTechnology(technologies2.get(i).getTechnology());
	technologyResponse.setTechid(technologies2.get(i).getTechid());
	technologyResponse.setTechCount(employee.size());
	techResponse.add(technologyResponse);
	technologyResponse.setTechid(technologies2.get(i).getTechid());
	}
	return techResponse;
}
}