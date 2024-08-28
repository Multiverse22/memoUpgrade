package com.sparta.memoupgrade.repository;

import com.sparta.memoupgrade.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {

}
