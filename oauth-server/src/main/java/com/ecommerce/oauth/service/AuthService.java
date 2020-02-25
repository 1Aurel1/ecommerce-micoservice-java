package com.ecommerce.oauth.service;

import com.ecommerce.oauth.model.User;
import com.ecommerce.oauth.repository.UserRepository;
import com.ecommerce.oauth.service.dto.UserDto;
import com.ecommerce.oauth.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> registerUser(UserDto userDto){

        User user = userMapper.userDtoTOUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        user = userRepository.save(user);
        userDto = new UserDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
