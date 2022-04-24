package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.dto.PerfilDTO;
import com.salvatierravictor.portfolio.entity.AcercaEntity;
import com.salvatierravictor.portfolio.entity.EducacionEntity;
import com.salvatierravictor.portfolio.entity.PerfilEntity;
import com.salvatierravictor.portfolio.mapper.PerfilMapper;
import com.salvatierravictor.portfolio.repository.PerfilRepository;
import com.salvatierravictor.portfolio.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    //=== Mapper ===
    @Autowired
    private PerfilMapper perfilMapper;

    //=== Repository ===
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public PerfilDTO save(PerfilDTO perfilDTO) {

        PerfilEntity perfilEntity = perfilMapper.perfilDTO2Entity(perfilDTO);

        PerfilEntity perfilGuardado = perfilRepository.save(perfilEntity);

        PerfilDTO resultado = perfilMapper.perfilEntity2Dto(perfilGuardado);

        return resultado;
    }

    @Override
    public PerfilDTO getPerfil(Long id) {

        AcercaEntity acercaEntity = new AcercaEntity();
        Optional<PerfilEntity> entity = this.perfilRepository.findById(id);

        PerfilDTO result = this.perfilMapper.perfilEntity2Dto(entity.get());

        return result;
    }

    @Override
    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    @Override
    public PerfilDTO editPerfil(Long id, PerfilDTO edit) {
        PerfilEntity savedPerfil = this.getPerfilEdit(id);

        /*savedPerfil.setNombre(edit.getNombre());
        savedPerfil.setTitulo(edit.getTitulo());
        savedPerfil.setUbicacion(edit.getUbicacion());
        savedPerfil.setProyectoEntities(edit.getProyectoId());
        savedPerfil.setEducacionEntities(edit.getEducacionId());
        savedPerfil.setAcercaEntities(edit.getAcercaEntities());
         */

        PerfilEntity editPerfil = perfilRepository.save(savedPerfil);
        PerfilDTO savedDTO = perfilMapper.perfilEntity2Dto(editPerfil);
        return savedDTO;
    }

    PerfilEntity getPerfilEdit(Long id) {
        Optional<PerfilEntity>perfilEntity= perfilRepository.findById(id);
        return perfilEntity.get();
    }


}

