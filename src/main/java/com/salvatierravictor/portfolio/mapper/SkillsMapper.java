package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.SkillsDTO;
import com.salvatierravictor.portfolio.model.Skills;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class SkillsMapper {

    public Skills skillsDTO2Entity(SkillsDTO skillsDTO) {
        Skills skills = new Skills();
        skills.setImageUrl(skillsDTO.getImageUrl());
        skills.setName(skillsDTO.getName());
        skills.setPercentage(skillsDTO.getPercentage());
        return skills;
    }

    public SkillsDTO skillsEntity2Dto(Skills skills) {
        SkillsDTO skillsDTO = new SkillsDTO();
        skillsDTO.setId(skills.getId());
        skillsDTO.setImageUrl(skills.getImageUrl());
        skillsDTO.setName(skills.getName());
        skillsDTO.setPercentage(skills.getPercentage());
        return skillsDTO;
    }

    public Collection<SkillsDTO> skillsListEntity2Dto(Collection<Skills> skillsEntities) {
        return skillsEntities.stream().map(skills->skillsEntity2Dto(skills)).collect(Collectors.toList());
    }

}
