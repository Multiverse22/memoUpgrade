package com.sparta.memoupgrade.controller;

import com.sparta.memoupgrade.dto.memo.MemoGetResponseDto;
import com.sparta.memoupgrade.dto.memo.MemoPostRequestDto;
import com.sparta.memoupgrade.dto.memo.MemoResponseDto;
import com.sparta.memoupgrade.dto.memo.MemoUpdateRequestDto;
import com.sparta.memoupgrade.service.MemoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    protected MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/memo")
    public MemoResponseDto saveMemo(@RequestBody MemoPostRequestDto requestDto) {
        return memoService.saveMemo(requestDto);
    }

    @GetMapping("/memo/{id}")
    public MemoGetResponseDto getMemo(@PathVariable long id) {
        return memoService.getMemo(id);
    }

    @DeleteMapping("/memo/{id}")
    public Long deleteMemo(@PathVariable long id) {
        return memoService.deleteMemo(id);
    }

    @PutMapping("/memo/{id}")
    public MemoResponseDto updateMemo(@RequestBody MemoUpdateRequestDto requestDto, @PathVariable long id) {
        return memoService.updateMemo(requestDto, id);
    }
}
