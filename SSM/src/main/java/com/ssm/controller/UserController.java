package com.ssm.controller;

import com.ssm.pojo.Result;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
        {id} -> 占位符：用于客户端给服务器传递请求参数数据
        同时，在方法的参数上使用 @PathVariable 来接收参数
     */
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping
    public Result<List<User>> findAll() {
        return userService.findAll();
    }

    /*
        @RequestBody 注解：表示请求参数发送的是一个 JSON 对象。
        并且，这个 JSON 对象中的属性要和方法中传入的 User 对象的属性对应才能接收的属性值，
        否则，User 对象中没有对应的属性，它的值为 null

        @Valid 注解：对传入的数据进行校验，以 User 对象中的属性上写的校验为校验标注。
        特别注意：GET 请求参数中一般是没有实体对象的，所以不能使用 @Valid
        （注解需要导入依赖使用 hibernate-validator）
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@Valid @RequestBody User user, BindingResult result) {
        // 如果有数据校验错误
        if (result.hasErrors()) {
            // 获取所有校验错误的字段
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField() + " -> " + fieldError.getDefaultMessage());
            }
        }
        System.out.println(user);
    }

    /*
        @ExceptionHandler 注解：是 Spring 框架中用于异常处理的一个注解，指定该方法用于处理某种特定的异常。
        但是真正项目中我们会把异常处理封装到一个全局异常类中。
     */
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
}
