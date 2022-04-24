package com.salvatierravictor.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "perfil")
@SQLDelete(sql = "UPDATE perfil SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private boolean deleted = Boolean.FALSE;

    private String nombre;

    private String titulo;

    private String ubicacion;

    //=== Tiene un acerca ==
    @OneToMany(cascade = {
            CascadeType.ALL

    }
    )
    private List<AcercaEntity> acercaEntities;

    //=== Tiene muchos estudios ==
    @OneToMany(cascade = {
            CascadeType.ALL

    }
    )
    private List<EducacionEntity> educacionEntities;

    //=== Tiene muchos estudios ==
    @OneToMany(cascade = {
            CascadeType.ALL

    })
    private List<ProyectoEntity> proyectoEntities;

    //=== Tiene muchas habilidades ==
    @OneToMany(cascade = {
        CascadeType.ALL

    }
    )
    private List<HabilidadesEntity> habilidadesEntities;

}
