package com.sparta.memoupgrade.dto.memo;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MemoResponseDto {
    private String message;
    private Integer status;
    private Long userId;
}
