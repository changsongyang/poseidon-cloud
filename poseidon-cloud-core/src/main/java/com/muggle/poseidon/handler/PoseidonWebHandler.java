package com.muggle.poseidon.handler;

import com.muggle.poseidon.base.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: poseidon-cloud-core
 * @description:
 * @author: muggle
 * @create: 2020-03-12 09:54
 */
@RestController
public class PoseidonWebHandler implements ErrorController {


    @Value("${spring.application.name}")
    private String appName;

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(PoseidonWebHandler.class);

    @RequestMapping(value = "/public/notfound", produces = "application/json;charset=UTF-8")
    public ResultBean notfund(HttpServletRequest request) {
        log.info("》》》》》》》》》》》》》》》》》 客户端访问了错误的页面");
        return ResultBean.error("找不到页面", 404);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping("/")
    public ResultBean getMessage() {
        return ResultBean.successData(appName);
    }


    @RequestMapping(value = "/error", produces = "application/json;charset=UTF-8")
    public ResultBean error(HttpServletRequest request) {
        return ResultBean.error("请求未响应，请稍后再试");
    }
}
