package com.demo.web;

import com.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 Spring 框架提供的 @Component 注解，将当前类交给 Spring 管理
    @Controller 注解：和 @Component 作用相同，只是区分语义化用于 web 层

    @ResponseBody 注解：注在类上，表示类中的所有方法响应的数据都转为 json 格式的字符串
                       注在方法上，表示当前方法返回的数据转为 json 格式的字符串

    @RestController 注解：@Controller + @ResponseBody

    @RequestMapping 注解：注在类上，表示访问这个类的总路径；注在方法上，表示访问这个方法对应的路径
        SpringMVC 针对不同的请求方式，给出更便捷的注解：
            @GetMapping：对应 get 方式请求，查询
            @PostMapping：对应 post 方式请求，添加
            @PutMapping：对应 put 方式请求，修改
            @DeleteMapping：对应 delete 方式请求，删除
*/
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(path = "userList")
    // @RequestMapping(value ="userList") value 与 path 作用相同
    // @ResponseBody
    public List<User> users() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("亚索" + i);
            user.setSex(i % 2 == 0 ? "男" : "女");
            userList.add(user);
        }
        return userList;
    }

    // @GetMapping 注解：允许 get 请求进入方法
    @GetMapping("/getUser")
    public String getUser() {
        System.out.println("getUser....");
        return "获取用户";
    }

    // @PostMapping 注解：允许 post 请求进入方法
    /* SpringMVC 中，如果客户端提交是普通的表单数据，那么要保证请求参数中的key值与方法中的参数名一致，才能正确接收。
        public String addUser(String name, String sex){}
        如果请求参数中的key值与 pojo 中的类的属性一一对应，那么方法中就可以使用一个对象进行接收。
        public String addUser(User user){}
        如果客户端提交的是json格式的数据，那么要在方法中的参数前使用 @ResponseBody 注解。
        public String addUser(@ResponseBody User user){}
    */
    @PostMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        return "addUser";
    }

    /*
        method = {RequestMethod.POST} ：限制请求方法
        params = {"id = *"} ：限制请求必须携带的参数
     */
    @RequestMapping(path = "/deleteUser", method = {RequestMethod.POST}, params = {"id=1"})
    public String deleteUser(Integer id) {
        System.out.println(id);
        return "根据 id 删除用户";
    }

    /*
        使用 @RequestParam 注解对参数进行限制
        name ：请求中的参数名，也就是 key 值
        required ：是否是必填项，默认为 true，必填
        defaultValue ：默认值
        如果没有使用 @RequestParam 注解，方法的参数名要和请求的参数名一致，
        如果使用了 @RequestParam 注解，name 的属性值要和请求的参数名一致，方法中的参数不作要求。
    */
    @RequestMapping("/addUser2")
    public String addUser2(
            @RequestParam(name = "name", required = true) String aaa,
            @RequestParam(name = "age", required = true, defaultValue = "18") String sex,
            @RequestParam(name = "sex", required = false, defaultValue = "保密") Integer age
    ) {
        System.out.println(aaa);
        System.out.println(sex);
        System.out.println(age);
        return "addUser2";
    }
}
