package com.portfolio.portfolio.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="past_Employment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Past_Employment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long user_id;
	private String company_name;
	private String job_role;
	private LocalDate start_date;
	private LocalDate end_date;
	private Boolean is_current;
	private String description;
}
