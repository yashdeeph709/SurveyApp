package com.xoriant.model;



public class Employee {
	String empId;
	String ename;
	String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String ename, String password) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}

}
