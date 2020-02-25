package com.ecommerce.oauth.controller;

import com.ecommerce.oauth.service.AuthService;
import com.ecommerce.oauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto) {

        return authService.registerUser(userDto);
    }
}
