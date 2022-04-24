package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.entity.EducacionEntity;
import com.salvatierravictor.portfolio.mapper.EducacionMapper;
import com.salvatierravictor.portfolio.repository.EducacionRepository;
import com.salvatierravictor.portfolio.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducacionServiceImpl implements EducacionService {

    //=== Mapper ===
    @Autowired
    private EducacionMapper educacionMapper;

    //=== Repository ===
    @Autowired
    private EducacionRepository educacionRepository;


    @Override
    public EducacionDTO save(EducacionDTO educacionDTO) {

        EducacionEntity educacionEntity = educacionMapper.educacionDTO2Entity(educacionDTO);

        EducacionEntity educacionGuardado = educacionRepository.save(educacionEntity);

        EducacionDTO resultado = educacionMapper.educacionEntity2Dto(educacionGuardado);

        return resultado;
    }

    @Override
    public EducacionDTO getEducacion(Long id) {

        Optional<EducacionEntity> entity = this.educacionRepository.findById(id);

        EducacionDTO result = this.educacionMapper.educacionEntity2Dto(entity.get());

        return result;
    }

    @Override
    public void delete(Long id) {
        educacionRepository.deleteById(id);
    }
}
