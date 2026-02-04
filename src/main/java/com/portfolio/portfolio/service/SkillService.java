package com.portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.SkillDto;
import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.exception.ResourceNotFoundException;
import com.portfolio.portfolio.exception.SkillAlreadyExistException;
import com.portfolio.portfolio.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository repo;
	
	//CREATE SKILL
	public Skill addSkill(SkillDto skilldto) {
		if(repo.existsByName(skilldto.getName())) {
			throw new SkillAlreadyExistException("Skill already exist"+skilldto.getName());
		}
		Skill skill=new Skill();
		skill.setName(skilldto.getName());
		skill.setCategory(skilldto.getCategory());
		skill.setProficiency_level(skilldto.getProficiency());
		skill.setIcon_url(skilldto.getIconUrl());
		
		return repo.save(skill);
	}
	
	//GET ALL SKILLS
	public List<Skill> getAllSkills(){
		return repo.findAll();
	}
	
	//GET SKILL BY ID
	public Skill getSkillById(Long id) {
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Skill not found with id"+id)
		);
	}
	//  UPDATE Skill
	public Skill updateSkill(Long id, SkillDto updatedSkillDto) {

    Skill exist = getSkillById(id);

    exist.setName(updatedSkillDto.getName());
    exist.setCategory(updatedSkillDto.getCategory());
    exist.setProficiency_level(updatedSkillDto.getProficiency());
    exist.setIcon_url(updatedSkillDto.getIconUrl());

    return repo.save(exist);
	}

	// DELETE Skill
	public void deleteSkill(Long id) {

    Skill existing = getSkillById(id);
    //  Remove skill from all projects
    for (Project project : existing.getProjects()) {
        project.getSkills().remove(existing);
    }

    //  Now delete skill safely
    repo.delete(existing);
	}
}
