package com.creditacceptance.bookbuddy.com.bookbuddybe.controllers;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.UserDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto fetchedUser = userService.findUserById(id);
        return ResponseEntity.ok(fetchedUser);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
