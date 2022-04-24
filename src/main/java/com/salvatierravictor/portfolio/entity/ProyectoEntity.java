package com.salvatierravictor.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "proyecto")
@SQLDelete(sql = "UPDATE proyecto SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String informacion;

    private String imagenUrl;

    private boolean deleted = Boolean.FALSE;

}
