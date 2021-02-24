package com.jzjr.springmvc.springmvc_demo.core.exception;

import com.jzjr.springmvc.springmvc_demo.constants.ServiceExceptionEnum;

public class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
// ... 省略 getting 方法}
}