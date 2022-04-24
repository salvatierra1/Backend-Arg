package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.AcercaDTO;
import com.salvatierravictor.portfolio.entity.AcercaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AcercaMapper {

    public AcercaEntity acercaDTO2Entity(AcercaDTO acercaDTO) {

        AcercaEntity acercaEntity = new AcercaEntity();

        acercaEntity.setInformacion(acercaDTO.getInformacion());
        return acercaEntity;

    }

    public AcercaDTO acercaEntity2Dto(AcercaEntity acercaGuardado) {

        AcercaDTO acercaDTO = new AcercaDTO();
        acercaDTO.setInformacion(acercaGuardado.getInformacion());
        return acercaDTO;
    }


}
