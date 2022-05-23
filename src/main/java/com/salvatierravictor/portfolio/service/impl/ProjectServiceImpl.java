package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.ProjectDTO;
import com.salvatierravictor.portfolio.model.About;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.model.Project;
import com.salvatierravictor.portfolio.mapper.ProjectMapper;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.repository.ProjectRepository;
import com.salvatierravictor.portfolio.service.ProfileService;
import com.salvatierravictor.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    //=== Mapper ===
    @Autowired
    private ProjectMapper projectMapper;

    //=== Repository ===
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectRepository.save(projectMapper.projectDTO2Entity(projectDTO));
        Profile profile = profileRepository.findAll().get(0);
        profile.getProjectEntities().add(project);
        profileRepository.save(profile);
        return projectMapper.projectEntity2Dto(project);
    }

    @Override
    public ProjectDTO getByIdProject(Long id) {
        Optional<Project> entity = this.projectRepository.findById(id);
        return projectMapper.projectEntity2Dto(entity.get());
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDTO editByIdProject(Long id, ProjectDTO edit) {
        Project project = this.getProjectEdit(id);
        project.setName(edit.getName());
        project.setInformation(edit.getInformation());
        project.setImageUrl(edit.getImageUrl());
        project.setRepoUrl(edit.getRepoUrl());
        Project editProject = projectRepository.save(project);
        return projectMapper.projectEntity2Dto(editProject);
    }

    Project getProjectEdit(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.get();
    }
}
