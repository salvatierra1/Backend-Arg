package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.ProfileCompleteDTO;
import com.salvatierravictor.portfolio.dto.ProfileDTO;
import com.salvatierravictor.portfolio.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {


    @Autowired
    private SkillsMapper skillsMapper;

    @Autowired
    private AboutMapper aboutMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private ProjectMapper projectMapper;

    public Profile profileDTO2Entity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setName(profileDTO.getName());
        profile.setTitle(profileDTO.getTitle());
        profile.setLocation(profileDTO.getLocation());
        profile.setImageUrl(profileDTO.getImageUrl());
        return profile;
    }

    public ProfileDTO profileEntity2Dto(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setName(profile.getName());
        profileDTO.setTitle(profile.getTitle());
        profileDTO.setLocation(profile.getLocation());
        profileDTO.setImageUrl(profile.getImageUrl());
        return profileDTO;
    }

    public ProfileCompleteDTO profileCompleteEntity2Dto(Profile profile) {
        ProfileCompleteDTO profileDTO = new ProfileCompleteDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setName(profile.getName());
        profileDTO.setTitle(profile.getTitle());
        profileDTO.setLocation(profile.getLocation());
        profileDTO.setImageUrl(profile.getImageUrl());
        profileDTO.setSkillsCollection(skillsMapper.skillsListEntity2Dto(profile.getSkillsEntities()));
        profileDTO.setAboutCollection(aboutMapper.aboutListEntity2Dto(profile.getAboutEntities()));
        profileDTO.setEducationCollection(educationMapper.educationListEntity2Dto(profile.getEducationEntities()));
        profileDTO.setProjectCollection(projectMapper.projectListEntity2Dto(profile.getProjectEntities()));
        return profileDTO;
    }

}
