package com.sparta.memoupgrade.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="memo")
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memoId;

    @Column(nullable = false,length = 50)
    private String username;

    @Column(nullable = false,length = 50)
    private String email;
}
