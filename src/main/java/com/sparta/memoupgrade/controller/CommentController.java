package com.sparta.memoupgrade.controller;

import com.sparta.memoupgrade.dto.comment.CommentGetResponseDto;
import com.sparta.memoupgrade.dto.comment.CommentPostResponseDto;
import com.sparta.memoupgrade.dto.comment.CommentRequestDto;
import com.sparta.memoupgrade.dto.comment.CommentResponseDto;
import com.sparta.memoupgrade.entity.Comment;
import com.sparta.memoupgrade.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    protected CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //댓글작성
    @PostMapping("/{memoId}")
    public CommentPostResponseDto saveComment(@PathVariable Long memoId, @RequestBody CommentRequestDto requestDto) {
        return commentService.saveComment(memoId,requestDto);
    }
    //댓글 단건조회
    @GetMapping("/{commentId}")
    public CommentGetResponseDto GetComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }
    //댓글 리스트 조회
    @GetMapping("/comments/{memoId}")
    public List<CommentGetResponseDto> getAllComments(@PathVariable Long memoId) {
        return commentService.getAllComments(memoId);
    }
    //댓글 삭제
    @DeleteMapping("/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
    //댓글 수정
    @PutMapping("/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(commentId,requestDto);
    }
}
