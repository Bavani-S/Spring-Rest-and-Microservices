package com.springrest.project.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springrest.project.model.Project;
import com.springrest.project.model.Projects;


@Repository//This is spring framework repository -> In-Memory Database
//ex- h2,jelly, reddis
//Spring jparepository is for heavy duty relational database. ex. MySQL, SQL,ORACLE
public class ProjectDAO {
	static Projects plist=new Projects();
	static {
		LocalDateTime ldt=LocalDateTime.now();
		Project p1=new Project();
		p1.setProjectName("HSBC");
		p1.setStartDate(ldt);
		p1.setEndDate(ldt.plusDays(300));
		
		Project p2=new Project();
		p2.setProjectName("Shell Corportion");
		p2.setStartDate(ldt);
		p2.setEndDate(ldt.plusDays(300));
		
		plist.getProjectList().add(p1);
		plist.getProjectList().add(p2);
		System.err.println("Projects list initialised...");
	}
	public Projects getAllProjects() {
		// TODO Auto-generated method stub
		return plist;
	}
	public void addProject(Project p) {
		// TODO Auto-generated method stub
		plist.getProjectList().add(p);
	}
	public void deleteProject(String projectname) {
		// TODO Auto-generated method stub
		List<Project> list = plist.getProjectList();
		for(Project p: list) {
			if(p.getProjectName().equalsIgnoreCase(projectname))
			{
				list.remove(p);
				System.out.println("Project deleted");
			}
		}
	}
	
	}
