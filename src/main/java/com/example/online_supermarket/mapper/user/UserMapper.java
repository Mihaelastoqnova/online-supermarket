package com.example.online_supermarket.mapper.user;

import com.example.online_supermarket.model.dto.UserDto;
import com.example.online_supermarket.model.dto.UserRegisterRequestDto;
import com.example.online_supermarket.model.entity.user.User;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class UserMapper {

    public static User toUserEntity(UserRegisterRequestDto userRegisterRequestDto){
           return User.builder()
                   .username(userRegisterRequestDto.getUsername())
                   .firstName(userRegisterRequestDto.getFirstName())
                   .lastName(userRegisterRequestDto.getLastName())
                   .email(userRegisterRequestDto.getEmail())
                   .password(userRegisterRequestDto.getPassword())
                   .profilePicture(userRegisterRequestDto.getProfilePicture())
                   .createdOn(LocalDateTime.now())
                   .updatedOn(LocalDateTime.now())
                   .build();


    }

    public static UserDto toUserDto(User userEntity) {
        if (userEntity == null){
            return null;
        }

        return UserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }
}
