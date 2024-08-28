package com.sparta.memoupgrade.dto.user;

import com.sparta.memoupgrade.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserGetAllResponseDto {
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UserGetAllResponseDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
