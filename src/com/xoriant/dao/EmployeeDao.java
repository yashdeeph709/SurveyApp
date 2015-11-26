package com.xoriant.dao;

import java.util.ArrayList;

import com.xoriant.model.Employee;

public enum EmployeeDao {
	instance;
	
	ArrayList<Employee> empList= new ArrayList<Employee>();
	
	public ArrayList<Employee> getAllEmployee(){
		return empList;
	}
}
