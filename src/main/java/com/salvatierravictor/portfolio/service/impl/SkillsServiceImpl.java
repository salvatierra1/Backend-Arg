package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.SkillsDTO;
import com.salvatierravictor.portfolio.mapper.SkillsMapper;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.model.Skills;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.repository.SkillsRepository;
import com.salvatierravictor.portfolio.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillsServiceImpl implements SkillsService {

    //=== Mapper ===
    @Autowired
    private SkillsMapper skillsMapper;

    //=== Repository ===
    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public SkillsDTO save(SkillsDTO skillsDTO) {
        Skills skills = skillsRepository.save(skillsMapper.skillsDTO2Entity(skillsDTO));
        Profile profile = profileRepository.findAll().get(0);
        profile.getSkillsEntities().add(skills);
        profileRepository.save(profile);
        return skillsMapper.skillsEntity2Dto(skills);
    }

    @Override
    public SkillsDTO getByIdSkills(Long id) {
        Optional<Skills> entity = skillsRepository.findById(id);
        return skillsMapper.skillsEntity2Dto(entity.get());
    }

    @Override
    public void delete(Long id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public SkillsDTO editByIdSkills(Long id, SkillsDTO edit) {
        Skills skills = this.getSkillsEdit(id);
        skills.setName(edit.getName());
        skills.setPercentage(edit.getPercentage());
        Skills editSkills = skillsRepository.save(skills);
        return skillsMapper.skillsEntity2Dto(editSkills);
    }

    Skills getSkillsEdit(Long id) {
        Optional<Skills> skills = skillsRepository.findById(id);
        return skills.get();
    }
}
