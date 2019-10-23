package com.question.service;

import java.util.List;

import com.question.pojo.Page;
import com.question.pojo.QuestionType;

public interface IQuestionService {
	List<QuestionType> getAllTypes();
	List<Integer> getAllLevel();
	Page getQuestionByCondition(int typeid, int level,int pageno, int size);
	
}
