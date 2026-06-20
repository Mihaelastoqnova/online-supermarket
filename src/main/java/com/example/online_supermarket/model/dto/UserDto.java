package com.example.online_supermarket.model.dto;

import com.example.online_supermarket.model.entity.user.UserRole;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class UserDto {

    UUID id;
    String username;
    String firstName;
    String lastName;
    String profilePicture;
    String email;
    UserRole role;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
