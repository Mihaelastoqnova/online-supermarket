package com.example.online_supermarket.service.user;

import com.example.online_supermarket.mapper.user.UserMapper;
import com.example.online_supermarket.model.dto.UserDto;
import com.example.online_supermarket.model.dto.UserRegisterRequestDto;
import com.example.online_supermarket.model.entity.basket.Basket;
import com.example.online_supermarket.model.entity.user.User;
import com.example.online_supermarket.repository.user.UserRepository;
import com.example.online_supermarket.service.basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BasketService basketService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, BasketService basketService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.basketService = basketService;
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

        basketService.createBasketForUser(userEntity);
    }
}
