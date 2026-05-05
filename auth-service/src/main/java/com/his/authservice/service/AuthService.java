package com.his.authservice.service;

import org.springframework.stereotype.Service;

import com.his.authservice.dtos.LoginRequest;
import com.his.authservice.dtos.LoginResponse;

@Service
public class AuthService {
    public LoginResponse login(LoginRequest loginRequest) {
        String accessToken ="dummy-access-token";
        String refreshToken ="dummy-refresh-token";
        return new LoginResponse(accessToken, refreshToken);
    }

}