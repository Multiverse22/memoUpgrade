package com.sparta.memoupgrade.dto.memo;

import com.sparta.memoupgrade.entity.Memo;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class MemoGetResponseDto {
    private Long memoId;
    private String userName;
    private String title;
    private String memoContents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public MemoGetResponseDto(Memo memo) {
        this.memoId=memo.getId();
        this.userName=memo.getUserName();
        this.title=memo.getTitle();
        this.memoContents=memo.getMemoContents();
        this.createdAt=memo.getCreatedAt();
        this.modifiedAt=memo.getModifiedAt();
    }
}
