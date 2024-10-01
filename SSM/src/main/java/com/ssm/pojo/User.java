package com.ssm.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    // 用户名
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    /*
        "^1[3-9][0-9]{11}$" ：正则表达式
        ^ ：代表开始，$ ：代表结束
        1 ：第一位是 1
        [3-9] ：代表第二位是 3-9 中的任意一个数字
        [0-9] ：代表第三位是 0-9 中的任意一个数字
        {9} ：代表 [0-9] 这个规则执行 9 次
     */
    @Pattern(regexp = "^1[3-9][0-9]{9}$",message = "手机号格式错误，必须是 11 位")
    private String tel;
    // 姓名
    private String name;
    // 年龄
    @Max(value = 18, message = "年龄不能超过18岁")
    private Integer age;
    // 性别
    @Max(value = 1, message = "性别只能是0和1,0 = 女；1 = 男")
    @Min(value = 0, message = "性别只能是0和1,0 = 女；1 = 男")
    private Integer sex;
    // 出生日期
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;
}
