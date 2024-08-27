package com.sparta.memoupgrade.service;

import com.sparta.memoupgrade.repository.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    protected MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }
}
