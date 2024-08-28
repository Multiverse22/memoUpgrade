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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User writer;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(name = "memo_contents",nullable = false,length = 50)
    private String memoContents;

    @OneToMany(mappedBy = "memo",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

//    @OneToMany(mappedBy = "memo",fetch = FetchType.LAZY)
//    private List<Draft> draftList = new ArrayList<>();

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
