package com.ssm.exception;

import com.ssm.pojo.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局异常
 */
// @RestControllerAdvice 是 Spring 框架中一个用于统一处理控制器异常和返回结果的注解。
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Map<Object, Object>> handleException(MethodArgumentNotValidException e) {
        Map<Object, Object> map = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return Result.fail(5000, "数据校验失败", map);
    }

    @ExceptionHandler(ArithmeticException.class)
    public Result<Map<Object, Object>> handleException(ArithmeticException e) {
        Map<Object, Object> map = new HashMap<>();
        map.put("ArithmeticException", e.getMessage());
        return Result.fail(5000, "数据校验失败", map);
    }

    /**
     * 将我们的自定义异常放到全局异常中处理
     */
    @ExceptionHandler(BizException.class)
    public Result<Map<Object, Object>> handleException(BizException e) {
        Map<Object, Object> map = new HashMap<>();
        map.put(e.getCode(), e.getMsg());
        return Result.fail(5000, "失败", map);
    }
}
