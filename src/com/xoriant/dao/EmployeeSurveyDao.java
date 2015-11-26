package com.xoriant.dao;

import java.util.HashMap;
import java.util.Map;

import com.xoriant.model.EmployeeSurvey;

public enum EmployeeSurveyDao {
	instance;

	private Map<String, EmployeeSurvey> employeeSurveyList = new HashMap<String, EmployeeSurvey>();

	private EmployeeSurveyDao(){
		employeeSurveyList.put("e01001", new EmployeeSurvey("e01001", "e01", "Rahul", "001", "Which Floor do you like", "4th Floor", "Open"));
		employeeSurveyList.put("e01002", new EmployeeSurvey("e01002", "e01", "Rahul", "002", "Which Technology you like", "Java", "Open"));
		employeeSurveyList.put("e03001", new EmployeeSurvey("e03001", "e03", "Sachin", "001", "Which Floor do you like", "2nd Floor", "Open"));
		employeeSurveyList.put("e04001", new EmployeeSurvey("e04001", "e04", "Dhoni", "001", "Which Floor do you like", "2nd Floor", "Open"));
	}
	public Map<String, EmployeeSurvey> getAllSurveyConduced() {
		return employeeSurveyList;
	}
}
