package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Client;
import com.portfolio.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
	boolean existsBySourceCodeUrl(String SourceCodeUrl);
	boolean existByTitle(String Title);
	boolean existByClient(Client client);
}
