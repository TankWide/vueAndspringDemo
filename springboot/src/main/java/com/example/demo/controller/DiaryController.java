package com.example.demo.controller;

import com.example.demo.dao.entity.DiaryEntity;
import com.example.demo.service.BigCustomService;
import com.example.demo.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/diaryController")
public class DiaryController {
    @Autowired
    private BigCustomService bigCustomService;

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "/index";
    }

    //    @PostMapping(value = "/paginationApplyEdit")
    @PostMapping("/queryDiaryList")
    @ResponseBody
    public CommonReturnType queryDiaryList(@RequestBody DiaryEntity diaryEntity) throws Exception {
        CommonReturnType returnType = new CommonReturnType();
        List pagination = bigCustomService.queryDiaryList(diaryEntity);
        returnType.setCode(200);
        returnType.setData(pagination);
        return returnType;
    }

    @PostMapping(value = "/addDiary")
    @ResponseBody
    public Integer addDiary(@RequestBody DiaryEntity diaryEntity) throws Exception {
        Integer s = bigCustomService.addDiary(diaryEntity);
        return s;
    }
}
