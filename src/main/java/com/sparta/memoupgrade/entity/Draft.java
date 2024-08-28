//package com.sparta.memoupgrade.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Getter
//@Table(name = "draft")
//@NoArgsConstructor
//public class Draft {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "memo_id")
//    private Memo memo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Draft(Memo memo, User user) {
//        this.memo = memo;
//        this.user = user;
//    }
//}
