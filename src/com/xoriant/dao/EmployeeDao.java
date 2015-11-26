package com.xoriant.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.xoriant.model.Employee;

public enum EmployeeDao {
	instance;
	
	ArrayList<Employee> empList= new ArrayList<Employee>();
	{
		empList.add(new Employee("e01","yashdeep","hinge"));
	}
	public ArrayList<Employee> getAllEmployee(){
		return empList;
	}
	public boolean findEmployee(String eid,String password){
		Iterator<Employee> iterator=empList.iterator();
		while(iterator.hasNext()){
			Employee employee=iterator.next();
			Token t1=new Token(eid+":"+password);
			Token t2=new Token(employee.getEmpId()+":"+employee.getPassword());
			if(t1.equals(t2)){
				return true;
			}
		}
		return false;
	}
}
