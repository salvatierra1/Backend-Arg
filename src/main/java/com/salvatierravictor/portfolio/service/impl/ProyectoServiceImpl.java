package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.PerfilDTO;
import com.salvatierravictor.portfolio.dto.ProyectoDTO;
import com.salvatierravictor.portfolio.entity.PerfilEntity;
import com.salvatierravictor.portfolio.entity.ProyectoEntity;
import com.salvatierravictor.portfolio.mapper.PerfilMapper;
import com.salvatierravictor.portfolio.mapper.ProyectoMapper;
import com.salvatierravictor.portfolio.repository.PerfilRepository;
import com.salvatierravictor.portfolio.repository.ProyectoRepository;
import com.salvatierravictor.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    //=== Mapper ===
    @Autowired
    private ProyectoMapper proyectoMapper;

    //=== Repository ===
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public ProyectoDTO save(ProyectoDTO proyectoDTO) {

        ProyectoEntity proyectoEntity  = proyectoMapper.proyectoDTO2Entity(proyectoDTO);

        ProyectoEntity proyectoGuardado = proyectoRepository.save(proyectoEntity);

        ProyectoDTO resultado = proyectoMapper.proyectoEntity2Dto(proyectoGuardado);

        return resultado;
    }

    @Override
    public ProyectoDTO getProyecto(Long id) {

        Optional<ProyectoEntity> entity = this.proyectoRepository.findById(id);

        ProyectoDTO result = this.proyectoMapper.proyectoEntity2Dto(entity.get());

        return result;
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
}
