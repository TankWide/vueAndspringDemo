package com.example.demo.service.impl;

import com.example.demo.dao.BigCustomMapper;
import com.example.demo.service.BigCustomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigCustomServiceImpl implements BigCustomService {

//    @Autowired
//    private BigCustomMapper bigCustomMapper;


    /**
     * 查询大客户信息
     *
     * @param inputModel
     * @param
     */
    @Override
    // @SysLog("查询大客户信息 BigCustomServiceImpl---pagination")
    public List pagination(String inputModel) throws Exception {
        List outputDos = new ArrayList();
//        List outputDos = bigCustomMapper.pagination();
        return outputDos;
    }


}
