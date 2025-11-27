package com.example.either.controller;

import com.example.either.dto.AnswerDto;
import com.example.either.dto.QuestionDto;
import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import com.example.either.service.AnswerService;
import com.example.either.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    // 질문 목록 조회
    @GetMapping
    public String list(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "question/list";
    }

    // 질문 생성 폼
    @GetMapping("/new")
    public String newQuestion(Model model) {
        model.addAttribute("question", new QuestionDto());
        return "question/form";
    }

    // 질문 생성 처리
    @PostMapping
    public String create(@ModelAttribute Question question) {
        questionService.createQuestion(question);
        return "redirect:/questions";
    }

    @GetMapping("/{id}")
    public String detail(
        @PathVariable Long id,
        Model model
    ) {
        Question question = questionService.findById(id);
        List<Answer> answers = question.getAnswers();

        model.addAttribute("question", question);
        model.addAttribute("answer", new AnswerDto());
        model.addAttribute("answers", answers);

        return "question/detail";
    }



    // ================================================
    // =============== [ Answer Part ] ===============
    // ================================================


    @PostMapping("/{id}")
    public String createAnswer(
        @PathVariable Long id,
        @ModelAttribute Answer answer
    ) {
        /*
        @ModelAttribute
        - 내부적으로 Answer 엔티티 객체를 생성
        - 사용자가 입력한 HTML의 answerText content를 Answer 객체의 content에 매핑
        - 이후 아래의 코드를 실행
        */
//        answer.setId(null);
        answerService.createAnswer(id, answer);
        return "redirect:/questions/" + id;
    }

}
