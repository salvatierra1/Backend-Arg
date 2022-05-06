package com.salvatierravictor.portfolio.auth.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Email(message = "Username must be an email")
    private String username;

    @Size(min = 8)
    private String password;

}
