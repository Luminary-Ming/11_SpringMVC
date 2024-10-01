package com.demo.web;

import com.demo.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResponseController {
    // ModelAndView：它是 SpringMVC 内置的一个类，主要用于处理响应的数据与视图名称。
    @RequestMapping("/resp")
    public ModelAndView demo() {
        ModelAndView mv = new ModelAndView();
        List<User> users = new ArrayList<>();
        mv.setViewName("响应的视图名称");
        mv.addObject("key", "value");
        mv.addObject("user", users);
        return mv;
    }

    @RequestMapping("/resp2")
    @ResponseBody
    public Integer demo2() {
        return 1;
    }

    @RequestMapping("/resp3")
    @ResponseBody
    public Integer demo3() {
        return 1;
    }

    @RequestMapping("/resp5")
    @ResponseBody
    public List<User> demo4() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setSex("男" + i);
            user.setName("李四" + i);
            user.setId(i);
            user.setLike(new String[]{"java", "python"});
            users.add(user);
        }
        return users;
    }

    @RequestMapping("/resp6")
    @ResponseBody
    public Map<String, Object> demo6() {
        Map<String, Object> map = new HashMap<>();
        map.put("username","亚索");
        map.put("age",20);
        map.put("sex","男");
        map.put("address",new String[]{"天津","北京","上海"});
        return map;
    }
    @RequestMapping("/resp7")
    // 设置响应的状态码
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void demo7(){
        System.out.println("只接收客户端的请求，但是不给客户端响应任何数据");
    }

    /**
     * 请求转发
     */
    @RequestMapping("/forward")
    public String demo8(){
        System.out.println("请求接收到喽....");
        return "forward:/response/resp4";
    }

    /**
     * 请求重定向
     */
    @RequestMapping("/redirect")
    public String demo9(){
        System.out.println("请求接收到了.....");
        return "redirect:/response/resp5";
    }

}
