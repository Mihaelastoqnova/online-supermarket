package com.example.online_supermarket.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterRequestDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePicture;
}
