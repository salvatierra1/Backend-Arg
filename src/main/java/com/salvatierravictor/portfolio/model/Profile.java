package com.salvatierravictor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profile")
@SQLDelete(sql = "UPDATE profile SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private boolean deleted = Boolean.FALSE;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The location cannot be empty")
    private String location;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

    @OneToMany(cascade = {
            CascadeType.ALL

    }
    )
    private Collection<About> aboutEntities;


    @OneToMany(cascade = {
            CascadeType.ALL

    }
    )
    private Collection<Education> educationEntities;

    @OneToMany(cascade = {
            CascadeType.ALL

    })
    private Collection<Project> projectEntities;

    @OneToMany(cascade = {
            CascadeType.ALL

    }
    )
    private Collection<Skills> skillsEntities;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public Profile(String name, String title, String location, String imageUrl) {
        this.name = name;
        this.title = title;
        this.location = location;
        this.imageUrl = imageUrl;
    }
}
