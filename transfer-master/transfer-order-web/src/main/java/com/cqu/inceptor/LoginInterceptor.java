package com.cqu.inceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
*  登录检查
*  1. 配置好拦截器要拦截哪些请求
*  2. 配置类导入该拦截器
*/


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    /*
    *  目标方法执行之前
    * @param request
    * @param response
    * @param handler
    * @return
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("拦截的路径是："+requestURI);

        //登录检查逻辑
        HttpSession httpSession= request.getSession();
        Object loginUser= httpSession.getAttribute("loginUser");
        if(loginUser!=null){
            return true;
        }

        //拦截住，未登录。跳转到登录页
        request.setAttribute("msg","请先登录");
        // re.sendRedirect("/")
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
