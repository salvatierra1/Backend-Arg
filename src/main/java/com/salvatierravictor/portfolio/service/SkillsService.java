package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.SkillsDTO;

public interface SkillsService {

    SkillsDTO save(SkillsDTO skillsDTO);

    SkillsDTO getByIdSkills(Long id);

    void delete(Long id);

    SkillsDTO editByIdSkills(Long id, SkillsDTO edit);
}
