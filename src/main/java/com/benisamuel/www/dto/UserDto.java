package com.benisamuel.www.dto;

import com.benisamuel.www.enums.Role;
import jakarta.validation.constraints.*;

import lombok.Getter;

@Getter
public class UserDto {
    @NotBlank(message = "name can't be blank")
    private String name;

    @NotBlank(message = "email field can't be empty")
    @Email(message = "use a standard email format")
    private String email;

    @Size(max = 8, message = "password can be at least of 8 character")
    private String password;

    @NotBlank(message = "role field can't be empty")
    private Role role;
}
