package com.xoriant.resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xoriant.dao.EmployeeDao;
import com.xoriant.model.Employee;

@Path("Employees")
public class EmployeeResource {

	// 7) Register Employee for the Survey
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void registerEmployeeForSurvey(@FormParam("empId") String empId,
			@FormParam("ename") String ename,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) throws IOException {
		Employee emp = new Employee(empId, ename);
		EmployeeDao.instance.getAllEmployee().add(emp);
		servletRequest.getSession().setAttribute("empId", empId);
		servletRequest.getSession().setAttribute("ename", ename);
		servletResponse.sendRedirect("../survey.jsp");
	}

	// 8) List the Employee who registered for the Survey
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> getEmployeeList() {
		List<Employee> EmpList = EmployeeDao.instance.getAllEmployee();
		return EmpList;
	}

}
