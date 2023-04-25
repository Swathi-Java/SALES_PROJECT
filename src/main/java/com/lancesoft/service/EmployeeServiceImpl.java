package com.lancesoft.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lancesoft.dao.EmployeeDao;
import com.lancesoft.dao.ProjectsDao;
import com.lancesoft.dao.TechnologiesDao;
import com.lancesoft.entity.Count;
import com.lancesoft.entity.Employee;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.Projects;
import com.lancesoft.entity.Technologies;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ProjectsDao projectsDao;
	@Autowired
	TechnologiesDao technologiesDao;
	@Autowired
	HttpServletResponse httpServletResponse;

	@Override

	public HashSet<EmployeeResponse> getManager(String techid) {
		Technologies technology = technologiesDao.findByTechid(techid);
		List<Employee> list = employeeDao.findBytechlist(technology);
		HashSet<EmployeeResponse> listOfManagers = new HashSet<>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			if (employee.getDesignation().equals("manager")) {
				EmployeeResponse employeeRes = new EmployeeResponse();
				employeeRes.setEmpid(employee.getEmpid());
				employeeRes.setName(employee.getName());
				employeeRes.setEmail(employee.getEmail());
				employeeRes.setPhone(employee.getPhone());
				employeeRes.setTechnology(employee.getTechlist().get(0).getTechnology());
				employeeRes.setDesignation(employee.getDesignation());
				listOfManagers.add(employeeRes);
			}
			System.err.println(listOfManagers);
		}
		return listOfManagers;
	}

	@Override

	public Count count(String techid, String managerid, String empid) {
		// int projectcount=0;
		Technologies technology = technologiesDao.findByTechid(techid);
		Employee emp = employeeDao.findByEmpid(empid);
		List<Employee> employee = employeeDao.findBytechlistAndManagerid(technology, managerid);
		Count count = new Count();
		count.setEmployecount(employee.size());
		count.setEmail(emp.getEmail());
		count.setName(emp.getName());
		count.setPhone(emp.getPhone());
		count.setDesignation(emp.getDesignation());
		List<Employee> employ = employeeDao.findBytechlistAndEmpid(technology, empid);
		HashSet<String> projects = new HashSet<>();
		for (int i = 0; i < employ.size(); i++) {
			String e = employ.get(i).getProjlist().get(i).getProjectid();
			projects.add(e);
		}
		count.setProjectcount(projects.size());

		return count;

	}

	@Override
	public ResponseEntity<byte[]> gettimages(String empid) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		httpServletResponse.setContentType("image/png");
		System.err.println("---------error=----------------");
		return new ResponseEntity<byte[]>(employeeDao.findByEmpid(empid).getImage(), headers, HttpStatus.OK);

	}

	@Override
	public List<EmployeeResponse> employcount(String techid, String managerid) {
		Technologies technology = technologiesDao.findByTechid(techid);
		// Employee emp=employeeDao.findByEmpid(empid);
		List<Employee> employee = employeeDao.findBytechlistAndManagerid(technology, managerid);
		List<EmployeeResponse> listOfManagers = new ArrayList<>();
		for (int i = 0; i < employee.size(); i++) {
			EmployeeResponse employeeRes = new EmployeeResponse();
			employeeRes.setEmpid(employee.get(i).getEmpid());
			employeeRes.setName(employee.get(i).getName());
			employeeRes.setEmail(employee.get(i).getEmail());
			employeeRes.setPhone(employee.get(i).getPhone());
			employeeRes.setTechnology(employee.get(i).getTechlist().get(0).getTechnology());
			employeeRes.setDesignation(employee.get(i).getDesignation());
			listOfManagers.add(employeeRes);
		}
		return listOfManagers;
	}

	@Override
	public HashSet<Proj> projectCount(String techid, String empid) {
		HashSet<Proj> proj = new HashSet<>();
		Technologies technology = technologiesDao.findByTechid(techid);
		
		List<Employee> employ = employeeDao.findBytechlistAndEmpid(technology, empid);
        for(int i=0;i<employ.size();i++)
        {
		  Proj project=new Proj();
		  project.setProjectid(employ.get(i).getProjlist().get(i).getProjectid());
		  project.setProjectName(employ.get(i).getProjlist().get(i).getName());
		  project.setStatus(employ.get(i).getProjlist().get(i).getStatus());
		proj.add(project);
	
        }
		return proj;
	}
}
	