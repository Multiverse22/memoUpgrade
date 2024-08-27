package com.sparta.memoupgrade.dto.user;

import com.sparta.memoupgrade.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
