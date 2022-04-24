package com.salvatierravictor.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "educacion")
@SQLDelete(sql = "UPDATE educacion SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class EducacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String institucion;

    private String titulo;

    @Column(name = "fecha_inicio")
    @DateTimeFormat(pattern = "yyyy/MM/dd")

    private LocalDate fechaInicio;

    @Column(name = "fecha_finalizacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaFinalizacion;

    private String imagenUrl;

    private boolean deleted = Boolean.FALSE;

}
