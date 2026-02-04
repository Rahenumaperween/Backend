package com.portfolio.portfolio.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillDto {
	private String name;
    private String category;
    private Integer proficiency;
    private Integer level;
    private String iconUrl;
}
