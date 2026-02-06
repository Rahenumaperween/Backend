package com.portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolio.dto.ProjectDto;
import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.service.ProjectService;
@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {
	@Autowired
	private ProjectService service;
	
	 //  CREATE Project
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto dto) {
        return ResponseEntity.ok(service.addProject(dto));
    }
	 //  GET ALL Projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(service.getAllProjects());
    }
    //GET PROJECT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable long id){
    	return ResponseEntity.ok(service.getProjectById(id));
    }
    
    //UPDATE PROJECT
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable long id,
    		@RequestBody ProjectDto dto){
    	return ResponseEntity.ok(service.updateProject(id, dto));
    }
    //DELETE PROJECT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable long id){
    	service.deleteProject(id);
    	return ResponseEntity.ok("Project deleted successfully with id:"+id);
    }
    
}

