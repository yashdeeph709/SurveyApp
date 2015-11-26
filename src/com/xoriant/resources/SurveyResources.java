package com.xoriant.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xoriant.dao.SurveyDao;
import com.xoriant.model.Survey;

//The resource to the URI Surveys
@Path("Surveys")
public class SurveyResources {

	//1)	List all the Survey Conducting by Xoriant
	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyList() {
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.addAll(SurveyDao.instance.getAllSurvey().values());
		return surveyList;
	}

	// 2)	No of Survey Conducted by Xoriant
	@GET
	@Path("Counts")
	@Produces( MediaType.APPLICATION_JSON)
	public String getCountOfSurvey() {
		int count = SurveyDao.instance.getAllSurvey().size();
		return String.valueOf(count);
	}

	
	
	
	@GET
	@Path("{id}")
	@Produces( MediaType.APPLICATION_JSON)
	public Survey getSurvey(@PathParam("id") String id) {
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.instance.getAllSurvey().values());
		return listOfSurvey.get(Integer.valueOf(id));
	}
	
	
	
	//4)	Conduct Survey for the Employee  Randomly
	@GET
	@Path("Random")
	@Produces( MediaType.APPLICATION_JSON)
	public Survey getRandomSurvey() {
		Random random = new Random();
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.instance.getAllSurvey().values());
		int index = random.nextInt(listOfSurvey.size());
		return listOfSurvey.get(index);
	}
	
	//5)	Provide the List of Surveys which are Open/Closed
	@GET
	@Path("/Status/{status}")
	@Produces( MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyListByStatus(@PathParam("status") String status) {
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.instance.getAllSurvey().values());
		ArrayList<Survey> listOfSurveyStatus = new ArrayList<Survey>();
		for(Survey survey:listOfSurvey){
			if(survey.getStatus().equals(status)){
			listOfSurveyStatus.add(survey);
			}
		}
		
		return listOfSurveyStatus;
	}

	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addNewSurvey(@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("choice1") String choice1,
			@FormParam("choice2") String choice2,
			@FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException {
		Survey survey = new Survey(id, title, choice1, choice2, status);
		SurveyDao.instance.getAllSurvey().put(id, survey);
		servletResponse.sendRedirect("/XoriantSurveyPortal/create_survey.html");
	}
	
	

}










