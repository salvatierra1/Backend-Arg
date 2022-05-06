package com.salvatierravictor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
@SQLDelete(sql = "UPDATE project SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean deleted = Boolean.FALSE;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The information cannot be empty")
    private String information;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public Project(String name, String information, String imageUrl) {
    }
}
