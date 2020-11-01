package com.example.demo.dao;

import com.example.demo.dao.entity.DiaryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BigCustomMapper {


    List<DiaryEntity> queryDiaryList(DiaryEntity entity);

    int addDiary(DiaryEntity diaryEntity);

}
