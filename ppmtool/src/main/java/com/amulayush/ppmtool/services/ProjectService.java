package com.amulayush.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amulayush.ppmtool.domain.Project;
import com.amulayush.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService 
{

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project)
	{
		return projectRepository.save(project);
	}
	
}
