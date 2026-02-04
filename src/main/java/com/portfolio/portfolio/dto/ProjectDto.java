package com.portfolio.portfolio.dto;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDto {

    private String title;
    private String description;
    private String techStack;
    private String thumbnailUrl;
    private String liveDemoUrl;
    private String sourceCodeUrl;
    private Long clientId;
    private List<Long> skillIds;

}
