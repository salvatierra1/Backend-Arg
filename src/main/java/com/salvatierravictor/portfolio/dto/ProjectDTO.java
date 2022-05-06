package com.salvatierravictor.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The information cannot be empty")
    private String information;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

}
