package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

}
