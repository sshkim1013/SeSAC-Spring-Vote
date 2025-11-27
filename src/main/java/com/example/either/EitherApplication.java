package com.example.either;

import com.example.either.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EitherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EitherApplication.class, args);
    }

}
