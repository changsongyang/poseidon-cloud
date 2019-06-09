package com.muggle.handler;


import com.muggle.base.EmailBean;
import com.muggle.base.PoseidonException;
import com.muggle.base.PoseidonProperties;
import com.muggle.base.ResultBean;

import com.muggle.temp.EmailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: poseidon
 * @description: 异常统一处理类
 * @author: muggle
 * @create: 2018-09-06 16:22
 **/
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @Autowired
    EmailTemplate emailTemplate;
    @Value("${admin.email}")
    private String adminEmail;

    @ExceptionHandler(value = {PoseidonException.class})
    public ResultBean poseidonExceptionHandler(PoseidonException e, HttpServletRequest req) {
        return new ResultBean().setMsg(e.getMsg()).setCode(e.getCode());
    }
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResultBean MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req) {
        System.out.println(e.getMessage());
        return new ResultBean().setMsg("数据未通过校验").setCode(PoseidonProperties.COMMIT_DATA_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResultBean exceptionHandler(Exception e, HttpServletRequest req) {
        log.error("系统异常：" + req.getMethod() + req.getRequestURI(), e);
        try {
//
            EmailBean emailBean = new EmailBean();
            emailBean.setRecipient(adminEmail);
            emailBean.setSubject("poseidon---系统异常");
            emailBean.setContent("系统异常：" + req.getMethod() + req.getRequestURI()+"----"+e.getMessage());
//            改良
            emailTemplate.sendSimpleMail(emailBean);
        } finally {
            return new ResultBean().setMsg("系统异常，请联系管理员").setCode("500");
        }
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResultBean notsupported(Exception e, HttpServletRequest req) {
        return new ResultBean().setMsg("不支持的请求方式").setCode(PoseidonProperties.NOT_SUPPORT_METHOD);
    }
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResultBean notFoundUrl(Exception e, HttpServletRequest req) {
        return new ResultBean().setMsg("请求路径不存在").setCode("404");
    }
}
