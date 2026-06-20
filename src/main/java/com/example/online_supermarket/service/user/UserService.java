package com.example.online_supermarket.service.user;

import com.example.online_supermarket.mapper.user.UserMapper;
import com.example.online_supermarket.model.dto.UserDto;
import com.example.online_supermarket.model.dto.UserRegisterRequestDto;
import com.example.online_supermarket.model.entity.user.User;
import com.example.online_supermarket.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public UserDto register(UserRegisterRequestDto userRegisterRequestDto){

        userRepository.findByUsername(userRegisterRequestDto.getUsername()).ifPresent(user -> {
            throw new RuntimeException("User with this username already exists!");
        });

        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.getPassword());
        userRegisterRequestDto.setPassword(encodedPassword);

        User userEntity = UserMapper.toUserEntity(userRegisterRequestDto);

        userRepository.save(userEntity);
        return UserMapper.toUserDto(userEntity);
    }
}
