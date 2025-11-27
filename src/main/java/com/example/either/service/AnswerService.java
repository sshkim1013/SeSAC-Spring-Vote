package com.example.either.service;

import com.example.either.entity.Answer;
import com.example.either.entity.Question;
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
        Question question = questionService.findById(id);
        question.addAnswer(answer);

        return answerRepository.save(answer);
    }



}
