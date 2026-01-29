package com.portfolio.portfolio.entity;

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
@Table(name="UI-Setting")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UI_Settings {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long user_id;
	private boolean dark_mode;
	private boolean animations_enabled;
	private String layout_preference;
	private String language;
}
