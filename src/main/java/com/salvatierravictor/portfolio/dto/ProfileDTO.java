package com.salvatierravictor.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The location cannot be empty")
    private String location;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

}
