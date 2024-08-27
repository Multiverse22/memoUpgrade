package com.sparta.memoupgrade.controller;

import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.service.MemoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    protected MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
}
