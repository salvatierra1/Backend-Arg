package com.salvatierravictor.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The name cannot be empty")
    private String password;

    public RoleEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
