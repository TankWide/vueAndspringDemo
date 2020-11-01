package com.example.demo.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DiaryEntity {

    private Integer id;
    private String diaryHead;
    private String diaryContent;
    private Integer userId;
    private String creatTime;
    private String userName;
    private Date startCreatTime;
    private Date endCreatTime;
}
