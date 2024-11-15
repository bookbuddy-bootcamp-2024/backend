package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto findUserById(Long id);
}
