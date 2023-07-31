package com.kugods.project.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kugods.project.exception.AnswerRepositoryException;
import com.kugods.project.vo.AnswerVo;

@Repository
public class AnswerRepository {

	@Autowired
	private SqlSession sqlSession;
	
	
	// AI가 생성한 질문을 받아옴.  
	public void insert(AnswerVo vo) throws AnswerRepositoryException {
		
		sqlSession.insert("answer.insert", vo);
	}
	
	
	//date랑 userID도 필요할듯 
	public List<AnswerVo> findAnswerByDate(String date) throws AnswerRepositoryException {
		Map<String, Object> map = new HashMap<>();
		map.put("date", date);
		
		/**
		 * 로그인한 유저의 아이디를 userID에 주기.
		 */
		//map.put("userID", userID );
		List<AnswerVo> list = sqlSession.selectList("answer.findAnswerByDate", date);
		return list;
	}
	
	// answerID, comment를 입력받아서 수정
	public void updateCommentByID(Long id, String comment) throws AnswerRepositoryException {
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("comment", comment);
		
		sqlSession.update("answer.updateCommentByID", map);
		
	}
	
	
	// Map<질문, 답변>으로 구성된 리스트로 리턴
	public List<Map<String, String>> findQuestionAndAnswerByUserID(Long userID) throws AnswerRepositoryException {
		
		// Question, Answer entity join -> userID로 질문, 답변 가져오기.
		List<Map<String, String>> list = sqlSession.selectList("answer.findQuestionAndAnswerByUserID", userID);
		
		return list;
		
		
	}
}
