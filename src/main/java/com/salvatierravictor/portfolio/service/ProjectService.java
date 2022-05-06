package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO save(ProjectDTO projectDTO);

    ProjectDTO getByIdProject(Long id);

    void delete(Long id);

    ProjectDTO editByIdProject(Long id, ProjectDTO edit);
}
