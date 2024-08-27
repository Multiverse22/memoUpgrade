package com.sparta.memoupgrade.dto.memo;

import lombok.Getter;

@Getter
public class MemoPostRequestDto {
    private String username;
    private String title;
    private String memoContents;
}
