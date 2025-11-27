package com.example.either.service;

import com.example.either.entity.Question;
import com.example.either.repository.QuestionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    // 전체 질문 조회
    public List<Question> findAll() {
        return questionRepository.findAll();
    }


    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }
}
