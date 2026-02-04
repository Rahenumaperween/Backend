package com.portfolio.portfolio.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String category;
	private Integer proficiency_level;
	private String icon_url;
	 @ManyToMany(mappedBy = "skills")
	    @JsonIgnore
	    private Set<Project> projects;
}
