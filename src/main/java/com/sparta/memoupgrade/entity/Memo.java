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

    @Column(name = "user_name",nullable = false,length = 50)
    private String userName;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(name = "memo_contents",nullable = false,length = 50)
    private String memoContents;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "memo",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "memo")
    private List<Draft> draftList = new ArrayList<>();


    public Memo(MemoPostRequestDto requestDto) {
        this.userName=requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.memoContents = requestDto.getMemoContents();
    }

    public void update(MemoUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.memoContents = requestDto.getMemoContents();
    }
}
