package com.jzjr.springmvc.springmvc_demo.core.web;

import com.jzjr.springmvc.springmvc_demo.common.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// 只拦截我们的 Controller 所在包，避免其它类似 swagger 提供的 API 被切面拦截
@ControllerAdvice(basePackages = "com.jzjr.springmvc.springmvc_demo.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (o instanceof CommonResult) {
            return o;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(o);
    }
}
