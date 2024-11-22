package com.creditacceptance.bookbuddy.com.bookbuddybe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginDto {
    private String username;
    private String email;
    private String password;
}
