package com.yugen.todomgmtbe.service;

import com.yugen.todomgmtbe.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

}
