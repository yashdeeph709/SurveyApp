package com.xoriant.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.xoriant.model.Employee;

public enum EmployeeDao {
	instance;
	
	ArrayList<Employee> empList= new ArrayList<Employee>();
	
	public ArrayList<Employee> getAllEmployee(){
		return empList;
	}
	public boolean findEmployee(String eid,String password){
		Iterator<Employee> iterator=empList.iterator();
		while(iterator.hasNext()){
			Employee employee=iterator.next();
			if(employee.getEmpId().equals(eid) && employee.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
}
