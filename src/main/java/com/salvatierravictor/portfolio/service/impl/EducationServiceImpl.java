package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.EducationDTO;
import com.salvatierravictor.portfolio.mapper.EducationMapper;
import com.salvatierravictor.portfolio.model.Education;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.repository.EducationRepository;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {

    //=== Mapper ===
    @Autowired
    private EducationMapper educationMapper;

    //=== Repository ===
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public EducationDTO save(EducationDTO educationDTO) {
        Education education = educationRepository.save(educationMapper.educationDTO2Entity(educationDTO));
        Profile profile = profileRepository.findAll().get(0);
        profile.getEducationEntities().add(education);
        profileRepository.save(profile);
        return educationMapper.educationEntity2Dto(education);
    }

    @Override
    public EducationDTO getByIdEducation(Long id) {
        Optional<Education> entity = this.educationRepository.findById(id);
        EducationDTO result = this.educationMapper.educationEntity2Dto(entity.get());
        return result;
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public EducationDTO editByIdEducation(Long id, EducationDTO edit) {
        Education education = this.getEducationEdit(id);
        education.setInstitute(edit.getInstitute());
        education.setTitle(edit.getTitle());
        education.setStartDate(educationMapper.String2LocalDate(edit.getStartDate()));
        education.setFinishDate(educationMapper.String2LocalDate(edit.getFinishDate()));
        education.setImageUrl(edit.getImageUrl());
        return educationMapper.educationEntity2Dto(educationRepository.save(education));
    }

    private Education getEducationEdit(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        return education.get();
    }
}
