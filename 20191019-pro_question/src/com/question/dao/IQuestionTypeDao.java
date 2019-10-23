package com.question.dao;

import java.util.List;

import com.question.pojo.Question;
import com.question.pojo.QuestionType;

public interface IQuestionTypeDao {
	List<QuestionType> getAllTypes();
}
