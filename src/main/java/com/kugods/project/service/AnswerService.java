package com.kugods.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kugods.project.repository.AnswerRepository;
import com.kugods.project.vo.AnswerVo;
import com.kugods.project.vo.QuestionVo;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;
	
	public void addAnswers(AnswerVo vo) {
		answerRepository.insert(vo);
	}
	
	public List<AnswerVo> selectAnswers(String date) {
		return answerRepository.findAnswerByDate(date);
	}
	
	public void updateAnswer(Long id, String comment) {
		answerRepository.updateCommentByID(id, comment);
	}
	
	public List<Map<String, String>> postQuestionAndAnswer(Long userID) {
		return answerRepository.findQuestionAndAnswerByUserID(userID);
	}
}
