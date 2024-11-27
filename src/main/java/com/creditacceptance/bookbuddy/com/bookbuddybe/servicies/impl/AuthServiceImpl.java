package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.impl;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.LoginDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.RegisterDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Role;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions.BookBuddyAPIException;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.RoleRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.UserRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.security.JwtTokenProvider;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {
        //check if user is in the db or not - if user is in db, throw an exception
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BookBuddyAPIException(HttpStatus.BAD_REQUEST, "Email is already in use");
        }

        //check if username is already in use - if so throw an exception
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BookBuddyAPIException(HttpStatus.BAD_REQUEST, "Username is already in use");

        }

        //if passes checks above, create user
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setFirstname(registerDto.getFirstName());
        user.setLastname(registerDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEmail(registerDto.getEmail());
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(LoginDto loginDto) {
        // if user is NOT in db, throw error with message
        if(!userRepository.existsByUsername(loginDto.getUsername())) {
            throw new BookBuddyAPIException(HttpStatus.BAD_REQUEST, "Username was not found");
        }

        //if email is NOT in db, throw error with message
        if(!userRepository.existsByEmail(loginDto.getEmail())) {
            throw new BookBuddyAPIException(HttpStatus.BAD_REQUEST, "Email was not found");
        }


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);

    }
}
