package com.sparta.memoupgrade.dto.comment;

import com.sparta.memoupgrade.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String userName;
    private String commentContents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUserName();
        this.commentContents = comment.getCommentContent();
        this.createAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

}
