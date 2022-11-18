package com.amulayush.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amulayush.ppmtool.domain.Project;
import com.amulayush.ppmtool.exceptions.ProjectIdException;
import com.amulayush.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService 
{

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project)
	{
		try
		{
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}
		catch(Exception e)
		{
			throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists");
		}
	}


	public Project findProjectByIdentifier(String projectId) 
	{
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null)
		{
			throw new ProjectIdException("Project ID does not exists");
		}
		return project;
	}
	
	
	public Iterable<Project> findAllProjects()
	{
		return projectRepository.findAll();
	}
	
	
	public void deleteProjectByIdentifier(String projectId)
	{
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null)
		{
			throw new ProjectIdException("Project ID " + projectId.toUpperCase() + " does not exists");
		}
		
		projectRepository.delete(project);
		
	}
	
}
