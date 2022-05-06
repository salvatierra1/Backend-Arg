package com.salvatierravictor.portfolio.mapper;


import com.salvatierravictor.portfolio.dto.ProjectDTO;
import com.salvatierravictor.portfolio.model.Project;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

  
    public Project projectDTO2Entity(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setInformation(projectDTO.getInformation());
        project.setImageUrl(projectDTO.getImageUrl());
        return project;
    }

    public ProjectDTO projectEntity2Dto(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setInformation(project.getInformation());
        projectDTO.setImageUrl(project.getImageUrl());
        return projectDTO;
    }

    public Collection<ProjectDTO> projectListEntity2Dto(Collection<Project> projectEntities) {
        return projectEntities.stream().map(project->projectEntity2Dto(project)).collect(Collectors.toList());
    }
}
