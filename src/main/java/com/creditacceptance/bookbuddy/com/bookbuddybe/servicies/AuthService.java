package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.LoginDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
