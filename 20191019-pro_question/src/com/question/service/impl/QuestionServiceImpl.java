package com.question.service.impl;

import java.util.List;

import com.question.dao.IQuestionDao;
import com.question.dao.IQuestionTypeDao;
import com.question.dao.impl.QuestionDaoImpl;
import com.question.dao.impl.QuestionTypeDaoImpl;
import com.question.pojo.Page;
import com.question.pojo.Question;
import com.question.pojo.QuestionType;
import com.question.service.IQuestionService;

public class QuestionServiceImpl implements IQuestionService {
	private IQuestionDao qdao = new QuestionDaoImpl();
	private IQuestionTypeDao qtdao = new QuestionTypeDaoImpl();
	@Override
	public List<QuestionType> getAllTypes() {
		// TODO Auto-generated method stub
		return qtdao.getAllTypes();
	}

	@Override
	public List<Integer> getAllLevel() {
		// TODO Auto-generated method stub
		return qdao.getAllLevel();
	}

	@Override
	public Page getQuestionByCondition(int typeid, int level, int pageno, int size) {
		Page page = new Page();
		if(pageno!=0) {
			page.setPageno(pageno);
		}
		if(size!=0) {
			page.setSize(size);
		}
		page.setTotalRecord(qdao.getAllQuestionsByType(typeid, level).size());
		page.setList(qdao.getQuestionsByCondition(typeid, level, page.getPageno(), page.getSize()));
		
		return page;
	}

}
