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

import com.portfolio.portfolio.dto.SkillDto;
import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.service.SkillService;
@RestController
@RequestMapping("/api/skills")
@CrossOrigin("*")
public class SkillController {
	@Autowired
	private SkillService service;
	
	// CREATE Skill
    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(service.addSkill(skillDto));
    }
    
    // GET ALL Skills
    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(service.getAllSkills());
    }
    
    // GET Skill By ID
    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSkillById(id));
    }
    
    // UPDATE Skill
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id,@RequestBody SkillDto skillDto) {

        return ResponseEntity.ok(service.updateSkill(id, skillDto));
    }
    
    //DELETE Skill
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {

        service.deleteSkill(id);

        return ResponseEntity.ok("Skill deleted successfully with id: " + id);
    }
}
