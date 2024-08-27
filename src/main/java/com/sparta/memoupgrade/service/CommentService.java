package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.dto.comment.CommentGetResponseDto;
import com.sparta.memoupgrade.dto.comment.CommentPostResponseDto;
import com.sparta.memoupgrade.dto.comment.CommentRequestDto;
import com.sparta.memoupgrade.dto.comment.CommentResponseDto;
import com.sparta.memoupgrade.entity.Comment;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.repository.CommentRepository;
import com.sparta.memoupgrade.repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private MemoRepository memoRepository;

    protected CommentService(CommentRepository commentRepository, MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
        this.commentRepository = commentRepository;
    }

    public CommentPostResponseDto saveComment(Long memoId, CommentRequestDto requestDto) {
        Memo memo = memoRepository.findById(memoId).
                orElseThrow(()-> new NoSuchElementException("해당 메모 없음"));
        Comment comment = new Comment(requestDto);
        comment.setMemo(memo);

        Comment saveComment = commentRepository.save(comment);

        return new CommentPostResponseDto("댓글 작성완료",200,memo.getId());

    }

    public CommentGetResponseDto getComment(Long commentId) {
        Comment comment = findComment(commentId);
        return new CommentGetResponseDto(comment);
    }

    public List<CommentGetResponseDto> getAllComments(Long memoId) {
        List<Comment> comments = commentRepository.findAllByMemoId(memoId);
        return comments.stream().map(CommentGetResponseDto::new).toList();
    }
    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto requestDto) {
        Comment comment = findComment(commentId);
        comment.update(requestDto);
        return new CommentResponseDto(comment);
    }

    public Long deleteComment(Long commentId) {
        Comment comment = findComment(commentId);
        commentRepository.delete(comment);
        return comment.getId();
    }

    public Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("해당 댓글이 없습니다!!"));
    }
}
