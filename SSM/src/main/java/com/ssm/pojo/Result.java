package com.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 统一返回结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    /*
        在修饰符（static）和返回值（Result<T>）中间的 <T> 是泛型方法的标志，这是一个泛型方法。
        泛型方法可以声明为 static 的，并且与普通的静态方法是一样的。
        泛型方法中可以传入泛型参数：
            public static <T,E> String staticMethod(String name, T t, E e){
                String res = "";
                res += name +"-"+ t +"-"+ e;
                System.out.println("静态泛型方法 ： "+res);
                return res;
            }
    */

    // 返回成功
    public static <T> Result<T> success() {
        return success("成功", null);
    }

    // 返回成功，并且返回数据
    public static <T> Result<T> success(T data) {
        return success("成功", data);
    }

    // 返回成功，并且返回数据，并且自定义 message 内容
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(2000, message, data);
    }
/*-------------------- 返回失败 ---------------------------------*/
    // 返回失败，并且自定义失败状态码
    public static <T> Result<T> fail() {
        return fail(5000, "失败");
    }

    // 返回失败，并且自定义失败状态码
    public static Result<Integer> fail(Integer code) {
        return fail(code, "失败");
    }

    // 返回失败，并且自定义失败状态码，自定义 message 内容
    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    // 返回失败，并且自定义失败状态码，自定义 message 内容
    public static Result<Map<Object, Object>>  fail(Integer code, String message, Map<Object,Object> map) {
        return new Result<>(code, message, map);
    }
}
