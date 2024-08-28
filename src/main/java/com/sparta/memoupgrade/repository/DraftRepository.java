package com.sparta.memoupgrade.repository;

import com.sparta.memoupgrade.entity.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftRepository extends JpaRepository<Draft, Integer> {
}
