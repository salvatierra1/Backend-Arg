package com.salvatierravictor.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDTO {

    private Long id;

    @NotNull(message = "The institute cannot be empty")
    private String institute;

    @NotNull(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The startDate cannot be empty")
    private String startDate;

    @NotNull(message = "The finishDate cannot be empty")
    private String finishDate;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

}
