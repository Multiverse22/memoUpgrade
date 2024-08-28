package com.sparta.memoupgrade.entity;

import com.sparta.memoupgrade.dto.comment.CommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

    /* 2단계 필수사항
        1. 일정에 댓글을 달 수 있습니다.
            a. 댓글과 일정은 연관관계를 가집니다.
        2. 댓글을 저장, 단건 조회, 전체 조회, 수정, 삭제할 수 있습니다.
        3. 댓글은 `댓글 내용`, `작성일`, `수정일`, `작성 유저명` 필드를 갖고 있습니다.
     */

@Entity
@Getter
@Table(name="comment")
@NoArgsConstructor
public class Comment extends Timestamped{

    //Memo와 Comment는 1대다 관계
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",nullable = false,length = 50)
    private String userName;

    @Column(name = "comment_contents",nullable = false,length = 200)
    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memo_id")
    private Memo memo;

    public void setMemo(Memo memo) {
        this.memo = memo;
    }

    public Comment(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.commentContent = requestDto.getCommentContents();
    }

    public void update(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.commentContent = requestDto.getCommentContents();
    }

}
