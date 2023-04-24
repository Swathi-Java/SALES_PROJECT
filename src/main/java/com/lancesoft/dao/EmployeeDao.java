package com.lancesoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lancesoft.entity.Employee;
import com.lancesoft.entity.Projects;
import com.lancesoft.entity.Technologies;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String>{

	public Employee findByEmpid(String empid);
	public List<Employee> findBytechlist(Technologies technologies);
	public List<Employee> findBytechlistAndEmpid(Technologies technologies,String empid);
	List<Employee> findBytechlistAndManagerid(Technologies techid,String managerid);
	List<Employee> findByprojlist(Projects proj);
	
}
