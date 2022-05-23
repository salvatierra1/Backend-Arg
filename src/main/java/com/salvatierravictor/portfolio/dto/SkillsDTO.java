package com.salvatierravictor.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillsDTO {

    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The percentage cannot be empty")
    private int percentage;


}
