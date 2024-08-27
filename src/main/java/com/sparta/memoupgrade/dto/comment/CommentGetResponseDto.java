package com.sparta.memoupgrade.dto.comment;

import com.sparta.memoupgrade.entity.Comment;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponseDto {
    private long id;
    private String userName;
    private String commentContent;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentGetResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUserName();
        this.commentContent = comment.getCommentContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
