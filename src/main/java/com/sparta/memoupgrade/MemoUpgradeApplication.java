package com.sparta.memoupgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemoUpgradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoUpgradeApplication.class, args);
    }

}
