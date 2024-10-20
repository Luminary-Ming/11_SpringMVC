package com.demo.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
    过滤器（Filter）与拦截器（Interceptor）区别：
    Filter：
        基于函数回调实现
        是Servlet规范的接口，依赖于Servlet容器
        一般是在 Web 工程中使用
        可以拦截所有进入容器的请求，包括静态资源请求和动态资源请求
    Interceptor：
        基于Java的反射机制和动态代理实现
        是Spring框架的组件，不依赖于Servlet容器
        主要拦截对Controller中方法的请求（方法调用之前，方法调用之后）
请求的处理流程为：
    Tomcat ==> Filter ==> Servlet ==> Interceptor ==> Controller
也就是说，过滤器在拦截器之前被触发。
*/
public class DemoInterceptor implements HandlerInterceptor {
    /*
        ● 执行时机：在请求处理之前（即控制器方法调用之前）执行。
          ● 返回值：
                true： 继续处理请求，往下执行控制器方法。
                false：终止请求，直接返回响应。
        ● 常见用途：用户身份验证、请求日志记录、权限检查等。
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("在请求处理之前（即控制器方法调用之前）执行");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /*
        ● 执行时机：在请求处理之后（即控制器方法调用之后），但在视图渲染之前执行。
        ● 常见用途：对模型数据进行加工、修改响应数据等。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在请求处理之后（即控制器方法调用之后），但在视图渲染之前执行");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /*
        ● 执行时机：在整个请求结束之后（即视图渲染完毕之后）执行。
        ● 常见用途：资源清理、异常处理、记录执行时间等。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在整个请求结束之后（即视图渲染完毕之后）执行");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
