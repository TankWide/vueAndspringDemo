package com.example.demo.dao;

import com.example.demo.dao.entity.SupplierFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupperFileMapper {


    int insertFile(SupplierFile userEntity);

    SupplierFile getUrl();

}
