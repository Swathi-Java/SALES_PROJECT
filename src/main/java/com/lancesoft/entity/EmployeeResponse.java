package com.lancesoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeResponse {

	private String empid;

	private String name;

	private String designation;

	private String email;
	
	private String phone;
    
	private String technology;


}
