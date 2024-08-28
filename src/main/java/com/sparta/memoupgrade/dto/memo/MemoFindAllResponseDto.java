package com.sparta.memoupgrade.dto.memo;

import com.sparta.memoupgrade.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoFindAllResponseDto {
    private String title;
    private String memoContents;
    private Long commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String postUser;

    public MemoFindAllResponseDto(Memo memo) {
        this.title = memo.getTitle();
        this.memoContents = memo.getMemoContents();
        this.commentCount = (long) memo.getCommentList().size();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
        this.postUser = memo.getWriter().getName();
    }
}
