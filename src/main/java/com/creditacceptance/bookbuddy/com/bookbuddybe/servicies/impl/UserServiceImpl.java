package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.impl;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.UserDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions.ResourceNotFound;
import com.creditacceptance.bookbuddy.com.bookbuddybe.mapper.UserMapper;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.UserRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User saveUser = userRepository.save(user);

        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public UserDto findUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User Not Found"));
        return  UserMapper.mapToUserDto(user);
    }
}
