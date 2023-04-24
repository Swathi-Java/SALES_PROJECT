package com.lancesoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employees")
public class Employee {
	@Id
	private String empid;
	private String name;
	private String designation;
	private String email;
	private String phone;
	private String bench;
	private String managerid;
	@Lob
	@JsonIgnore
	private byte[] image;
//	@ManyToMany
//	@JoinTable(name = "emp_details",
//			joinColumns = { @JoinColumn(name = "Empid") })
//	private List<Employee> employee;
	
	@ManyToMany
	@JoinTable(name = "emp_details",
	joinColumns = { @JoinColumn(name = "Empid") }, 
	inverseJoinColumns = {@JoinColumn(name = "Techid") })
	private List<Technologies> techlist;
	
	@ManyToMany
	@JoinTable(name = "emp_details",
	joinColumns = { @JoinColumn(name = "Empid") }, 
	inverseJoinColumns = {@JoinColumn(name="Projectid") })
	private List<Projects> projlist;
	
	@ManyToMany
	@JoinTable(name = "emp_details",
	joinColumns = { @JoinColumn(name = "Empid") }, 
	inverseJoinColumns = {@JoinColumn(name="Indid")})
	private List<Industries> indlist;
	
	
}
