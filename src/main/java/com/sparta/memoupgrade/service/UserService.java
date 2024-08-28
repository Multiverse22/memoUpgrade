package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.dto.memo.MemoGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserRequestDto;
import com.sparta.memoupgrade.dto.user.UserResponseDto;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.entity.User;
import com.sparta.memoupgrade.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto saveUser(UserRequestDto requestDto) {
        User user = new User(requestDto);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }
    //단건 조회
    public UserResponseDto getUser(Long userId) {
        User user = findUser(userId);
        return new UserResponseDto(user);
    }
    //전체 조회
//    public List<UserResponseDto> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream().map(UserResponseDto::new).toList();
//    }
    //삭제
    public Long deleteUser(Long userId) {
        User user = findUser(userId);
        userRepository.delete(user);
        return user.getId();
    }
    //업데이트
    public UserResponseDto updateUser(Long userId, UserRequestDto requestDto) {
        User user = findUser(userId);
        user.update(requestDto);
        return new UserResponseDto(user);
    }

    //id를 읽어서 해당하는 유저가 있는지 확인하는 메서드
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new NoSuchElementException("해당 유저가 업습니다."));
    }

    //5.유저를 전부가져오는 전체조회
    //@Param page,size
    public Page<UserGetAllResponseDto> getAllUsers(int page, int size) {
        Sort.Direction direction = Sort.Direction.ASC;
        //오름차순조회
        Sort sort = Sort.by(direction, "name");
        //이름을 기준으로 합니다.

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> userList = userRepository.findAll(pageable);

        return userList.map(UserGetAllResponseDto::new);


    }
}
