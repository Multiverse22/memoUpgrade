package com.sparta.memoupgrade.entity;

import com.sparta.memoupgrade.dto.user.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="user")
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @OneToMany(mappedBy = "writer",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Memo> memoList = new ArrayList<>();
    //5.일정을 작성한 작성자는 일정에 다른 유저들을 추가할 수 있다. 때문에 일정과 유저는 N:M 관계가 된다.
    @OneToMany(mappedBy = "managerUser")
    private List<Draft> draftList = new ArrayList<>();

    public User(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
    }

    public void update(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
    }
}
