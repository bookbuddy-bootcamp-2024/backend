package com.creditacceptance.bookbuddy.com.bookbuddybe.mapper;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.UserDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail());
    }
    public static User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstname(), userDto.getLastname(), userDto.getEmail());
    }
}
