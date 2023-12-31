package com.kugods.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kugods.project.service.QuestionService;
import com.kugods.project.vo.QuestionVo;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	//AI에게 질문리스트 받아서 저장 + (바로 프론트로 보낼까?)
	@PostMapping("/add")
	public void add(@RequestBody List<QuestionVo> voList) {
		
		questionService.addQuestion(voList);
		
		
	}
	
	

}
