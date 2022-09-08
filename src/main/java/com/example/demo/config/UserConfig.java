package com.example.demo.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepo;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner clr(UserRepo userepo) {
        return args -> {
            User bilal = new User(
                "bilal",
                "I call bilal hello world!",
                "lall",
                "adenlall@outlook.sa",
                "OX00.com",
                (short) 12212,
                (short) 49723,
                LocalDate.now()
            );
            User hol = new User(
                "hol",
                "hollow world!",
                "loll",
                "dssoooll@outlook.sa",
                "OX00.com",
                (short) 14642,
                (short) 28123,
                LocalDate.now()
            );
            User hoxl = new User(
                "hoxl",
                "backk x world!",
                "loll",
                "nooxox@outlook.sa",
                "OX00.com",
                (short) 271642,
                (short) 108923,
                LocalDate.now()
            );
            userepo.saveAll(List.of(bilal, hol, hoxl));
        };
    }
}
