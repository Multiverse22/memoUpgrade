//package com.sparta.memoupgrade.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Table(name="memo")
//public class User extends Timestamped {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "memoId")
//    private Long memoId;
//
//    @Column(nullable = false,length = 50)
//    private String username;
//
//    @Column(nullable = false,length = 50)
//    private String email;
//
//    @OneToMany
//    @JoinColumn(name = "memoId")
//    private List<Memo> MemoList = new ArrayList<>();
//}
