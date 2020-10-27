package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/helloController")
public class HelloController {
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "/index";
    }

//    @PostMapping(value = "/paginationApplyEdit")
    @RequestMapping("/first")
    @ResponseBody
    public String first(Model model, HttpServletResponse response) {
        String fitstStr = new String();
        fitstStr = "first";
        return fitstStr;
    }
}
