package com.example.either.service;

import com.example.either.entity.Answer;
import com.example.either.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {

    private final QuestionService questionService;
    private final AnswerRepository answerRepository;

    // 답변 생성
    @Transactional
    public Answer createAnswer(Long id, Answer answer) {

        // 질문 존재 여부 검증
        questionService.findById(id);

        return answerRepository.save(answer);
    }


}
