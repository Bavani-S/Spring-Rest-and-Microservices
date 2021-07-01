package com.springrest.project.controller;

import java.net.URI;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springrest.project.dao.ProjectDAO;
import com.springrest.project.model.Project;
import com.springrest.project.model.Projects;


@RestController
@RequestMapping("/project")
public class ProjectController extends ResponseEntityExceptionHandler{

	Logger logger=Logger.getLogger("customLogger");
	@Autowired
	private ProjectDAO projectdao;
	
	@GetMapping(value="/listprojects",produces = "application/json")
	public Projects getProjects(HttpServletRequest request) {
		String clientaddress = request.getRemoteAddr();
		Locale clientlocation = request.getLocale();
		logger.info("Client country : "+ clientlocation.getCountry());
		logger.info("Clien language : "+clientlocation.getLanguage());
		logger.info("Client IP address : "+ clientaddress);
		logger.info("List of projects");
		return projectdao.getAllProjects();
		
	}
	@GetMapping("/addNewProject")
	public ModelAndView addNewProject() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addproject");
		//mv.addObject("Today",new java.util.Date());
		return mv;
	}
	@PostMapping(path="/addProject",consumes="application/json",produces="application/json")
	public ResponseEntity<Object> addProject(@RequestBody Project p){
		projectdao.addProject(p);
		logger.info("Added project");
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{ProjectName}").buildAndExpand(p.getProjectName()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/deleteproject")
	public ResponseEntity<Object> deleteProject(@RequestParam("projectname") String projectname) {
		projectdao.deleteProject(projectname);
		logger.info("Project Deleted");
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{ProjectName}").buildAndExpand(projectname).toUri();
		return ResponseEntity.created(location).build();
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException m, HttpHeaders headers, HttpStatus status, WebRequest webreq){
		System.out.println("Exception : "+m.getMessage());
		System.out.println("Errorcount : "+m.getErrorCount());
		return super.handleMethodArgumentNotValid(m, headers, status, webreq);
	}
}