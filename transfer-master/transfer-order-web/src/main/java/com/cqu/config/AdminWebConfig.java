package com.cqu.config;

import com.cqu.inceptor.LoginInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*
* 1  编写一个拦截器实现HandlerInterceptor 接口
* 2  拦截器注册到容器中，（实现WebMvcConfigurer的 addInterceptors）
* 3  指定拦截规则【如果是拦截所有，静态资源也会被拦截】
*/
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截
                .excludePathPatterns("/","/login","/templates/**");    // 放行的请求

    }
}
