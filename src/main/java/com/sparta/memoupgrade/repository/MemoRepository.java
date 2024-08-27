package com.sparta.memoupgrade.repository;

import com.sparta.memoupgrade.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
