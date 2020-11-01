package com.example.demo.util.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtils;
import com.example.demo.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        System.out.println(token);
        // 执行认证
        if (token == null || "".equals(token.trim())) {
            return responseData(response);
        }
        // 获取 token 中的 user id
        Integer userId = JwtUtils.getUserId(token);
//        if (userId == null) {
//            return responseData(response);
//        }
        //用户不存在的情况 属于作假token进行登录
//        UserEntity user = userService.queryByUserId(userId);
//        if (user == null) {
//            return responseData(response);
//        }
        // 验证 token
        boolean flage = JwtUtils.checkToken(token, userId);
        //用户存在但是token也不是根据我的规则产生的说明也是假的
        if (flage == false) {
            return responseData(response);
        }
        //将验证通过后的用户信息放到请求中,继续往下执行
        request.setAttribute("user", userId);
        UserThreadLocal.set(userId);
        return true;
    }

    //响应数据
    public boolean responseData(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        json.put("msg", "token verify fail");
        json.put("code", "50000");
        String s = JSON.toJSONString(json);
        PrintWriter writer = response.getWriter();
        writer.println(s);
        return false;
    }

}

