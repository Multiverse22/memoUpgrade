package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.dto.memo.MemoGetResponseDto;
import com.sparta.memoupgrade.dto.memo.MemoPostRequestDto;
import com.sparta.memoupgrade.dto.memo.MemoResponseDto;
import com.sparta.memoupgrade.dto.memo.MemoUpdateRequestDto;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    protected MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    //메모 생성
    public MemoResponseDto saveMemo(MemoPostRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

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
}
