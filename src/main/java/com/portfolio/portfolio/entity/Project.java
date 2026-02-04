package com.portfolio.portfolio.entity;

import java.time.LocalDateTime;
import java.util.*;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String title;
	@Column(length=2000)
	private String description;
	 private String techStack;
	private String thumbnail_url;
	private String live_demo_url;
	private String source_code_url;
	private LocalDateTime created_at;
	
	// Many projects belong to One client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Many projects can have many skills
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();
}
