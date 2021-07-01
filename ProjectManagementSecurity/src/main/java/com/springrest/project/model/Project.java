package com.springrest.project.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

public class Project {
	
	@Range(min=100,max=10000,message="Project id cannot be null")
	int projectId;
	@Size(min=5,message="Not acceptable, project name should be longer than 5 chars")
	String projectName;
	@NotNull(message="Start date cannot be null")
	LocalDateTime startDate;
	@NotEmpty(message="End date cannot be null")
	LocalDateTime endDate;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	//curl  -d {"projectName":"Shell"} -X POST http://localhost:8080/Project/addProject
	

}
