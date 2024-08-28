package com.sparta.memoupgrade.controller;

import com.sparta.memoupgrade.dto.memo.*;
import com.sparta.memoupgrade.service.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
@Slf4j
public class MemoController {

    private final MemoService memoService;

    protected MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
    //일정 작성
    @PostMapping("/{userId}")
    public MemoResponseDto saveMemo(@PathVariable Long userId,@RequestBody MemoPostRequestDto requestDto) {
        log.info("saveMemo시작");
        return memoService.saveMemo(userId,requestDto);
    }
    //일정 단건 조회
    @GetMapping("/{id}")
    public MemoGetResponseDto getMemo(@PathVariable long id) {
        return memoService.getMemo(id);
    }
    //3. 일정 다건 조회 (수정일기준내림차순)
    @GetMapping
    public Page<MemoFindAllResponseDto> getAllMemos(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10")int size
    ) {
        return memoService.getAllMemo(page,size);
    }
    //일정 삭제
    @DeleteMapping("/{id}")
    public Long deleteMemo(@PathVariable long id) {
        return memoService.deleteMemo(id);
    }
    //일정 업데이트
    @PutMapping("/{id}")
    public MemoResponseDto updateMemo(@RequestBody MemoUpdateRequestDto requestDto, @PathVariable long id) {
        return memoService.updateMemo(requestDto, id);
    }
}
