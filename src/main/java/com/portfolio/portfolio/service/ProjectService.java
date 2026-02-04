package com.portfolio.portfolio.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.ProjectDto;
import com.portfolio.portfolio.entity.Client;
import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.exception.ProjectAlreadyExist;
import com.portfolio.portfolio.exception.ResourceNotFoundException;
import com.portfolio.portfolio.repository.ClientRepository;
import com.portfolio.portfolio.repository.ProjectRepository;
import com.portfolio.portfolio.repository.SkillRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository repo;
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	//ADD CLIENT
	public Project addProject(ProjectDto dto) throws ProjectAlreadyExist {
		if(repo.existByTitle(dto.getTitle()))
		{
			throw new ProjectAlreadyExist("Poject title already exist"+dto.getTitle());
		}
		else if(repo.existsBySourceCodeUrl(dto.getSourceCodeUrl()))
		{
			throw new ProjectAlreadyExist("Project URL already exist"+dto.getSourceCodeUrl());
		}
		Set<Skill> skills=new HashSet<>(skillRepo.findAllById(dto.getSkillIds()));
		Client client=clientRepo.findById(dto.getClientId()).orElseThrow(() -> new ResourceNotFoundException(
	                                                     "Client not found with id: " + dto.getClientId() ));
		Project project =new Project();
		project.setTitle(dto.getTitle());
	    project.setDescription(dto.getDescription());
	    project.setTechStack(dto.getTechStack());
	    project.setThumbnail_url(dto.getThumbnailUrl());
	    project.setLive_demo_url(dto.getLiveDemoUrl());
	    project.setSource_code_url(dto.getSourceCodeUrl());
	    project.setClient(client);
	    project.setSkills(skills);
	    return repo.save(project);
	}
	// GET ALL Projects
	public List<Project> getAllProjects() {
	    return repo.findAll();
	}

	//GET Project By ID
	public Project getProjectById(Long id) {
	    return repo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Project not found with id: " + id
	                    )
	            );
	}
	//  UPDATE Project
	public Project updateProject(Long id, ProjectDto updatedDto) {

    Project existing = getProjectById(id);
    Client client=clientRepo.findById(updatedDto.getClientId()).orElseThrow(() -> new ResourceNotFoundException(
            "Client not found with id: " + updatedDto.getClientId() ));
    
    existing.setTitle(updatedDto.getTitle());
    existing.setDescription(updatedDto.getDescription());
    existing.setThumbnail_url(updatedDto.getThumbnailUrl());
    existing.setLive_demo_url(updatedDto.getLiveDemoUrl());
    existing.setSource_code_url(updatedDto.getSourceCodeUrl());
    existing.setClient(client);
    Set<Skill> skills=new HashSet<>(skillRepo.findAllById(updatedDto.getSkillIds()));
    existing.getSkills().clear();
    existing.getSkills().addAll(skills);

    return repo.save(existing);
}

	//DELETE Project
	public void deleteProject(Long id) {

    Project existing = getProjectById(id);
    existing.getSkills().clear();
    repo.delete(existing);
}
}
