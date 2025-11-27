package com.example.either.controller;

import com.example.either.dto.QuestionDto;
import com.example.either.entity.Question;
import com.example.either.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public String list(Model model) {

        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "question/list";
    }

//    @GetMapping("/{id}")
//    public String detail(
//        @PathVariable Long id,
//        Model model
//    ) {
//        Question question = questionService.findById(id);
//
//    }

    @GetMapping("/new")
    public String newQuestion(Model model) {
        model.addAttribute("question", new QuestionDto());
        return "question/form";
    }

}
