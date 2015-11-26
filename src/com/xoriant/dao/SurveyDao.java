package com.xoriant.dao;

import java.util.HashMap;
import java.util.Map;

import com.xoriant.model.Survey;

public enum SurveyDao {
	instance;
	
	private Map<String,Survey> surveyList= new HashMap<String, Survey>();
	
	private SurveyDao(){
		
		surveyList.put("001",new Survey("001", "Which Floor do you like", "10th Floor", "2nd Floor", "Open"));
		surveyList.put("002",new Survey("002", "Which Technology you like", "Java", "Python", "Open"));
		surveyList.put("003",new Survey("003", "Which Phone OS you like", "Android", "iOS", "Close"));
		surveyList.put("004",new Survey("004", "What do you prefer while eating", "Spice", "Sweet", "Open"));
		
	}
	
	public Map<String,Survey> getAllSurvey(){
		return surveyList;
	}

}
