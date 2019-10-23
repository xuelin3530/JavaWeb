package com.question.dao;

import java.util.List;

import com.question.pojo.Question;

public interface IQuestionDao {
	List<Integer> getAllLevel();
	List<Question> getAllQuestionsByType(int type,int level);
	List<Question> getQuestionsByCondition(int typeid, int level,int pageno, int size);
}
