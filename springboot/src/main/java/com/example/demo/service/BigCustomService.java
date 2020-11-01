package com.example.demo.service;

import com.example.demo.dao.entity.DiaryEntity;

import java.util.List;

public interface BigCustomService {

	/**
	 * 查询日志信息
	 * 
	 * @param inputModel
	 * @param
	 */
	List queryDiaryList(String inputModel) throws Exception;

	Integer addDiary(DiaryEntity inputModel) throws Exception;

}
