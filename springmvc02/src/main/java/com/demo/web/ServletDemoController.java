package com.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 在项目中需要使用原生的 JavaWeb 对象时，只需要直接在方法上写上对应的对象即可
 */

@RestController
@RequestMapping("/servlet")
public class ServletDemoController {
    @RequestMapping("/servlet")
    public String getDemo(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name);
        System.out.println(age);
        System.out.println(session);
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName());
        }
        //response.setStatus(302);
        //response.setHeader("location","http://www.jd.com");
        //response.sendRedirect("http://www.jd.com");
        return "demo";
    }
}
