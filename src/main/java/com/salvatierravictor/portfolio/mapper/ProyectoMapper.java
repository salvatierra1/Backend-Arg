package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.ProyectoDTO;
import com.salvatierravictor.portfolio.entity.ProyectoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProyectoMapper {

  
    public ProyectoEntity proyectoDTO2Entity(ProyectoDTO proyectoDTO) {

        ProyectoEntity proyectoEntity = new ProyectoEntity();

        proyectoEntity.setNombre(proyectoDTO.getNombre());
        proyectoEntity.setInformacion(proyectoDTO.getInformacion());
        proyectoEntity.setImagenUrl(proyectoDTO.getImagenUrl());

        return proyectoEntity;

    }

    public ProyectoDTO proyectoEntity2Dto(ProyectoEntity proyectoGuardado) {

        ProyectoDTO proyectoDTO = new ProyectoDTO();

        proyectoDTO.setNombre(proyectoGuardado.getNombre());
        proyectoDTO.setInformacion(proyectoGuardado.getInformacion());
        proyectoDTO.setImagenUrl(proyectoGuardado.getImagenUrl());


        return proyectoDTO;
    }
}
