package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.dto.memo.MemoGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserGetAllResponseDto;
import com.sparta.memoupgrade.dto.user.UserRequestDto;
import com.sparta.memoupgrade.dto.user.UserResponseDto;
import com.sparta.memoupgrade.entity.Draft;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.entity.User;
import com.sparta.memoupgrade.repository.DraftRepository;
import com.sparta.memoupgrade.repository.MemoRepository;
import com.sparta.memoupgrade.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final MemoRepository memoRepository;
    private final DraftRepository draftRepository;

    public UserService(UserRepository userRepository, MemoRepository memoRepository, DraftRepository draftRepository) {
        this.userRepository = userRepository;
        this.memoRepository = memoRepository;
        this.draftRepository = draftRepository;
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
    //일정을 작성한 작성자 아이디와 같다면 일정에 매니저 Id를 추가합니다.
    public void mandateUserToMemo(Long userId,Long memoId,Long managerId) {
        Memo memo = findMemo(memoId);
        // 작성자와 메모를 찾아온다.
        if (!Objects.equals(userId,memo.getWriter().getId())) {
            /*메모의 작성자와 요청받은 userId는 다를수있다 때문에 요청받은
            유저의 아이디와 작성한 유저의 아이디가 같은지 확인해봐야한다.*/
            throw new IllegalArgumentException("해당 일정의 작성자가 아닙니다.");
        }
        User manager = findUser(managerId);
        if (manager == null) {
            throw new NoSuchElementException("해당 id의 매니저(유저)는 존재하지 않습니다.");
        }
        Draft draft = new Draft(memo,manager);
        log.info("Draft 저장 시작");
        draftRepository.save(draft);
        log.info("Draft 저장 끝");
    }

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
    //id를 읽어 해당하는 일정이 있는지 확인하는 메서드
    public Memo findMemo(Long memoId) {
        return memoRepository.findById(memoId).orElseThrow(()->new NoSuchElementException("해당 메모가 없습니다."));
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
