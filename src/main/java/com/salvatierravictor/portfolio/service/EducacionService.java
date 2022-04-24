package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.EducacionDTO;



public interface EducacionService {

    EducacionDTO save(EducacionDTO educacionDTO);

    EducacionDTO getEducacion(Long id);

    void delete(Long id);
}
