package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.EducationDTO;
import com.salvatierravictor.portfolio.model.Education;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class EducationMapper {

    public Education educationDTO2Entity(EducationDTO educationDTO) {
        Education education = new Education();
        education.setInstitute(educationDTO.getInstitute());
        education.setTitle(educationDTO.getTitle());
        education.setStartDate(this.String2LocalDate(educationDTO.getStartDate()));
        education.setFinishDate(this.String2LocalDate(educationDTO.getFinishDate()));
        education.setImageUrl(educationDTO.getImageUrl());
        return education;
    }

    public EducationDTO educationEntity2Dto(Education education) {
        EducationDTO educationDTO = new EducationDTO();
        educationDTO.setId(education.getId());
        educationDTO.setInstitute(education.getInstitute());
        educationDTO.setTitle(education.getTitle());
        educationDTO.setStartDate(education.getStartDate().toString());
        educationDTO.setFinishDate(education.getFinishDate().toString());
        educationDTO.setImageUrl(education.getImageUrl());
        return educationDTO;
    }

    //=== Date ===
    public LocalDate String2LocalDate(String stringDate) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formato);
        return date;
    }


    public Collection<EducationDTO> educationListEntity2Dto(Collection<Education> educationEntities) {
        return educationEntities.stream().map(education -> educationEntity2Dto(education)).collect(Collectors.toList());
    }
}
