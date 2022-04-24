package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.PerfilDTO;

import com.salvatierravictor.portfolio.entity.PerfilEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    @Autowired
    private AcercaMapper acercaMapper;

    public PerfilEntity perfilDTO2Entity(PerfilDTO perfilDTO) {

        PerfilEntity perfilEntity = new PerfilEntity();

        perfilEntity.setNombre(perfilDTO.getNombre());
        perfilEntity.setTitulo(perfilDTO.getTitulo());
        perfilEntity.setUbicacion(perfilDTO.getUbicacion());
        perfilEntity.setEducacionEntities(perfilDTO.getEducacionEntities());
        perfilEntity.setAcercaEntities(perfilDTO.getAcercaEntities());
        perfilEntity.setProyectoEntities(perfilDTO.getProyectoEntities());
        perfilEntity.setHabilidadesEntities(perfilDTO.getHabilidadesEntities());

        return perfilEntity;


    }

    public PerfilDTO perfilEntity2Dto(PerfilEntity perfilEntity) {

        PerfilDTO perfilDTO = new PerfilDTO();

        perfilDTO.setNombre(perfilEntity.getNombre());
        perfilDTO.setTitulo(perfilEntity.getTitulo());
        perfilDTO.setUbicacion(perfilEntity.getUbicacion());
        perfilDTO.setEducacionEntities(perfilEntity.getEducacionEntities());
        perfilDTO.setAcercaEntities(perfilEntity.getAcercaEntities());
        perfilDTO.setProyectoEntities(perfilEntity.getProyectoEntities());
        perfilDTO.setHabilidadesEntities(perfilEntity.getHabilidadesEntities());

        return perfilDTO;
    }
}
