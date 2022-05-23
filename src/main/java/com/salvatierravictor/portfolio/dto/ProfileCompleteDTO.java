package com.salvatierravictor.portfolio.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCompleteDTO {

    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The location cannot be empty")
    private String location;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

    private Collection<AboutDTO> aboutCollection;

    private Collection<EducationDTO> educationCollection;

    private Collection<SkillsDTO> skillsCollection;

    private Collection<ProjectDTO> projectCollection;

}
