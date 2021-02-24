package com.jzjr.springmvc.springmvc_demo.config;

import com.jzjr.springmvc.springmvc_demo.core.interceptor.FirstInterceptor;
import com.jzjr.springmvc.springmvc_demo.core.interceptor.SecondInterceptor;
import com.jzjr.springmvc.springmvc_demo.core.interceptor.ThirdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(secondInterceptor()).addPathPatterns("/user/current_user");
        registry.addInterceptor(thirdInterceptor()).addPathPatterns("/**");
    }
}
