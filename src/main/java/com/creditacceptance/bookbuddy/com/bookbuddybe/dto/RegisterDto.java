package com.creditacceptance.bookbuddy.com.bookbuddybe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}
