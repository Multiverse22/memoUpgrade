package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.dto.memo.*;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.entity.User;
import com.sparta.memoupgrade.repository.MemoRepository;
import com.sparta.memoupgrade.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private final UserRepository userRepository;

    protected MemoService(MemoRepository memoRepository, UserRepository userRepository) {
        this.memoRepository = memoRepository;
        this.userRepository = userRepository;
    }

    public Page<MemoFindAllResponseDto> getAllMemo(int page,int size) {
        Sort.Direction direction = Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "modifiedAt");

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Memo> memoList = memoRepository.findAll(pageable);

        return memoList.map(MemoFindAllResponseDto::new);


    }

    //메모 생성
    //5.메모 생성 할때 userId를 받아와야한다.
    public MemoResponseDto saveMemo(Long userId,MemoPostRequestDto requestDto) {
        //받아온 유저 id로 유저를 찾는다.
        User user = findUser(userId);
        Memo memo = new Memo(requestDto);
        //일정에 찾은 유저아이디를 set해서 이 일정을 해당유저가 작성했다고 저장한다.
        memo.setWriter(user);

        // DB 저장
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        return new MemoResponseDto("작성 완료",201, saveMemo.getId());
    }

    public MemoGetResponseDto getMemo(Long memoId) {
        //id값으로 메모찾기
        Memo memo = memoRepository.findById(memoId).
                orElseThrow(()->new NoSuchElementException("Id에 해당하는 할일이 없습니다."));
        //찾았다면 responseDto에 담아 반환
        MemoGetResponseDto responseDto = new MemoGetResponseDto(memo);
        return responseDto;
    }

    public Long deleteMemo(Long memoId) {

        Memo memo = memoRepository.findById(memoId).
                orElseThrow(()->new NoSuchElementException("Id에 해당하는 할일이 없습니다."));
        memoRepository.delete(memo);
        return memoId;
    }
    @Transactional
    //Transactional 어노테이션이 없으면 제대로 작동하지않는다.
    public MemoResponseDto updateMemo(MemoUpdateRequestDto requestDto, Long memoId) {
        Memo memo = memoRepository.findById(memoId).
                orElseThrow(()->new NoSuchElementException("Id에 해당하는 할일이 없습니다."));
        memo.update(requestDto);
        return new MemoResponseDto("수정 완료",201, memo.getId());
    }
    public User findUser(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(()->new NoSuchElementException("Id에 해당하는 유저가 없습니다."));
    }
    public Memo findMemoId(Long memoId) {
        return memoRepository.findById(memoId).
                orElseThrow(()->new NoSuchElementException("Id에 해당하는 할일이 없습니다."));
    }
}
