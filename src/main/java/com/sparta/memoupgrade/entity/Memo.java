package com.sparta.memoupgrade.entity;


import com.sparta.memoupgrade.dto.memo.MemoPostRequestDto;
import com.sparta.memoupgrade.dto.memo.MemoUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="memo")
public class Memo extends Timestamped {

    protected Memo() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoId;

    @Column(nullable = false,length = 50)
    private String userName;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(nullable = false,length = 50)
    private String memoContents;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;


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
