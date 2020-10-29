package com.example.demo.service.impl;

import com.example.demo.dao.BigCustomMapper;
import com.example.demo.dao.entity.DiaryEntity;
import com.example.demo.service.BigCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigCustomServiceImpl implements BigCustomService {

    @Autowired
    private BigCustomMapper bigCustomMapper;


    /**
     * 查询日志
     *
     * @param inputModel
     * @param
     */
    @Override
    // @SysLog("查询日志 BigCustomServiceImpl---pagination")
    public List pagination(String inputModel) throws Exception {
        List outputDos = new ArrayList();
        outputDos = bigCustomMapper.pagination();
        return outputDos;
    }

    @Override
    // @SysLog("查询日志 BigCustomServiceImpl---pagination")
    public Integer addDiary(DiaryEntity inputModel) throws Exception {
        int i = bigCustomMapper.addDiary(inputModel);
        return i;
    }
}
