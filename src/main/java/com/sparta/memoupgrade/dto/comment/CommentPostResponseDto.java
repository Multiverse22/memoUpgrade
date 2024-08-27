package com.sparta.memoupgrade.dto.comment;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentPostResponseDto {
    private String message;
    private Integer status;
    private Long userId;
}