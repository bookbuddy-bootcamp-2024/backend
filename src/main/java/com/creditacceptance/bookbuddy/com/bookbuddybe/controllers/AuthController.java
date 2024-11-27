package com.creditacceptance.bookbuddy.com.bookbuddybe.controllers;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.JwtAuthResponseDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.LoginDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.RegisterDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDto> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        JwtAuthResponseDto jwtAuthResponseDto = new JwtAuthResponseDto();
        jwtAuthResponseDto.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponseDto, HttpStatus.OK);
    }
}
