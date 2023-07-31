package com.kugods.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kugods.project.service.AnswerService;
import com.kugods.project.vo.AnswerVo;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	AnswerService answerService;

	// 답변 받아서 DB에 저장
	@PostMapping("/write")
	public void write(@RequestBody AnswerVo vo) {
		answerService.addAnswers(vo);

	}

	// 날짜에 따른 답변 리턴
	@PostMapping("/date")
	public List<AnswerVo> select(@RequestParam String date) {

		List<AnswerVo> list = answerService.selectAnswers(date);

		return list;

	}

	// 답변 수정
	@PostMapping("/modify")
	public void update( Long id, String comment) {
		
		answerService.updateAnswer(id, comment);
		
	}

	
	// AI에게 <질문,답변> 전달
	@PostMapping("/get")
	 public List<Map<String,String>> postInf(Long id) {
		List<Map<String,String>> list = answerService.postQuestionAndAnswer(id);
		return list;
	}
	
}
