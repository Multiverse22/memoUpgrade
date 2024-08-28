package com.sparta.memoupgrade.controller;


import com.sparta.memoupgrade.dto.memo.MemoGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserRequestDto;
import com.sparta.memoupgrade.dto.user.UserResponseDto;
import com.sparta.memoupgrade.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //유저 저장하기
    @PostMapping
    public UserResponseDto saveUser(@RequestBody UserRequestDto requestDto) {
        return userService.saveUser(requestDto);
    }
    //유저id,memo id,매니저id를 받아 해당메모가 유저id가 작성한게 맞으면 일정에 manager를 추가하는 API
    @PostMapping("/{userId}/memos/{memoId}/mandate/{managerId}")
    public String mandateUserToMemo(@PathVariable long userId, @PathVariable long memoId,
                                    @PathVariable long managerId) {
        userService.mandateUserToMemo(userId,memoId,managerId);
        return "";
    }

    //유저 가져오기
    //http://localhost:8080/api/users/{userId}
    @GetMapping("/{userId}")
    public UserResponseDto getUser (@PathVariable Long userId){
        return userService.getUser(userId);
    }
    //전체 조회
    //http://localhost:8080/api/users?page=0&size=5
    @GetMapping
    public Page<UserGetAllResponseDto> getAllMemos(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10")int size
    ) {
        return userService.getAllUsers(page,size);
    }
    //유저 삭제
    @DeleteMapping("/{userId}")
    public Long deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
    //유저 수정
    @PutMapping("/{userId}")
    public UserResponseDto updateUser(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        return userService.updateUser(userId, requestDto);
    }
}
