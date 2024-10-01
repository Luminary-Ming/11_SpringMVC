package com.ssm.exception;

import lombok.Getter;

/**
 * 自定义异常，将项目中可能发生的一些异常信息封装
 */
public class BizException extends RuntimeException {
    @Getter
    private Integer code;
    @Getter
    private String msg;

    public BizException(Integer code, String msg) {
        super(msg);  // 将异常信息丢给父类处理
        this.code = code;
        this.msg = msg;
    }
}
