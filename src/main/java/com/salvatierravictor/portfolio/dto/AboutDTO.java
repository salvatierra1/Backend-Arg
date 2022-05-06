package com.salvatierravictor.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDTO {

    private Long id;

    @NotNull(message = "The information cannot be empty")
    private String information;

}
