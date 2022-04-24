package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.entity.EducacionEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EducacionMapper {

    public EducacionEntity educacionDTO2Entity(EducacionDTO educacionDTO) {

        EducacionEntity educacionEntity = new EducacionEntity();

        educacionEntity.setTitulo(educacionDTO.getTitulo());
        educacionEntity.setInstitucion(educacionDTO.getInstitucion());
        educacionEntity.setImagenUrl(educacionDTO.getImagenUrl());

        educacionEntity.setFechaInicio(this.String2LocalDate(educacionDTO.getFechaInicio()));
        educacionEntity.setFechaFinalizacion(this.String2LocalDate(educacionDTO.getFechaFinalizacion()));

        return educacionEntity;

    }

    public EducacionDTO educacionEntity2Dto(EducacionEntity educacionGuardado) {
        EducacionDTO educacionDTO = new EducacionDTO();

        educacionDTO.setTitulo(educacionGuardado.getTitulo());
        educacionDTO.setInstitucion(educacionGuardado.getInstitucion());
        educacionDTO.setImagenUrl(educacionGuardado.getImagenUrl());
        educacionDTO.setFechaInicio(educacionGuardado.getFechaInicio().toString());
        educacionDTO.setFechaFinalizacion(educacionGuardado.getFechaFinalizacion().toString());
        return educacionDTO;
    }

    //=== Date ===
    public LocalDate String2LocalDate(String stringDate) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formato);
        return date;
    }
}
