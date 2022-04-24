package com.salvatierravictor.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "acercas")
@SQLDelete(sql = "UPDATE acercas SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class AcercaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String informacion;
    private boolean deleted = Boolean.FALSE;

}
