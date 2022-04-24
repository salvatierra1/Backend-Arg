package com.salvatierravictor.portfolio.dto;

import com.salvatierravictor.portfolio.entity.AcercaEntity;
import com.salvatierravictor.portfolio.entity.EducacionEntity;
import com.salvatierravictor.portfolio.entity.HabilidadesEntity;
import com.salvatierravictor.portfolio.entity.ProyectoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerfilDTO {

    private String nombre;

    private String titulo;

    private String ubicacion;

    //Acerca
    private List<AcercaEntity> acercaEntities;
    //Educacion
    private List<EducacionEntity> educacionEntities;
    //Proyecto
    private List<ProyectoEntity> proyectoEntities;
    //Habilidades
    private List<HabilidadesEntity> habilidadesEntities;


}
