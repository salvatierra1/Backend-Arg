package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.AcercaDTO;
import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.entity.AcercaEntity;
import com.salvatierravictor.portfolio.entity.EducacionEntity;
import com.salvatierravictor.portfolio.mapper.AcercaMapper;
import com.salvatierravictor.portfolio.repository.AcercaRepository;
import com.salvatierravictor.portfolio.service.AcercaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcercaServiceImpl implements AcercaService {

    //=== Mapper ===
    @Autowired
    private AcercaMapper acercaMapper;

    //=== Repository ===
    @Autowired
    private AcercaRepository acercaRepository;

    @Override
    public AcercaDTO save(AcercaDTO acercaDTO) {

        AcercaEntity acercaEntity = acercaMapper.acercaDTO2Entity(acercaDTO);

        AcercaEntity acercaGuardado = acercaRepository.save(acercaEntity);

        AcercaDTO resultado = acercaMapper.acercaEntity2Dto(acercaGuardado);

        return resultado;
    }

    @Override
    public AcercaDTO getAcerca(Long id) {

        Optional<AcercaEntity> entity = this.acercaRepository.findById(id);

        AcercaDTO result = this.acercaMapper.acercaEntity2Dto(entity.get());

        return result;

    }


    @Override
    public void delete(Long id) {

        acercaRepository.deleteById(id);

    }



}
