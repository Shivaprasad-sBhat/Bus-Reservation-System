package com.masai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {


    private String userName;


    private String password;


    private String firstName;


    private String lastName;


    private String contact;


    private String email;
}
