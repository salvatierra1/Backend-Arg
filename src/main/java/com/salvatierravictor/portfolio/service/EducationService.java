package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.EducationDTO;

public interface EducationService {

    EducationDTO save(EducationDTO educationDTO);

    EducationDTO getByIdEducation(Long id);

    void delete(Long id);

    EducationDTO editByIdEducation(Long id, EducationDTO edit);
}
