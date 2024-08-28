package com.sparta.memoupgrade.entity;


import com.sparta.memoupgrade.dto.memo.MemoPostRequestDto;
import com.sparta.memoupgrade.dto.memo.MemoUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="memo")
public class Memo extends Timestamped {

    protected Memo() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //일정을 작성할때 어떤유저가 작성했는지를 받아온다.
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User writer;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(name = "memo_contents",nullable = false,length = 50)
    private String memoContents;

    //해당일정에 연관된 댓글을 저장하는 리스트
    //메모한개에 여러개의 댓글이 있을수있기때문에 1:N 관계
    @OneToMany(mappedBy = "memo",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    //중간테이블 Draft 생성
    @OneToMany(mappedBy = "memo",fetch = FetchType.LAZY)
    private List<Draft> draftList = new ArrayList<>();

    public void setWriter(User writer) {
        this.writer = writer;
    }
    public Memo(MemoPostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.memoContents = requestDto.getMemoContents();
    }

    public void update(MemoUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.memoContents = requestDto.getMemoContents();
    }
}
