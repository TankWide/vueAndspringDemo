package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

@Data
/**
 * @author tangkk
 */
public class CommonReturnType implements Serializable {
    private static final long serialVersionUID = 1L;

    // 表明对应请求的返回处理结果"success"或"fail"
    private String status;
    private Integer code;
    // 若status=success，则data内返回前端需要的json数据
    // 若status=fail，则data内使用通用的错误码格式
    private Object data;
    private String message = "Account and password are incorrect.";

    // 定义一个通用的创建方法
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}

