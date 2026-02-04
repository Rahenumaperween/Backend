package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long>{
	 boolean existsByName(String name);

}
