package com.example.demo.dao.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private String password;
    private String token;
    private List roles;
}
