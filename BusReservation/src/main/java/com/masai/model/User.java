package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "user name cannot set as null")
    @NotEmpty(message = "user name cannot set as empty")
    @NotBlank(message = "user name cannot set as blank")
    @Column(unique = true)
    private String name;

    @NotNull(message = "password cannot set as null")
    @NotEmpty(message = "password cannot set as empty")
    @NotBlank(message = "password cannot set as blank")
    @Column(unique = true)
    private String password;

    private String role;

}
