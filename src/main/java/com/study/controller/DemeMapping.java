package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinfei.wang on 2019/7/18.
 */
@RestController
public class DemeMapping {
    Logger logger = LoggerFactory.getLogger(DemeMapping.class);

    @RequestMapping("log-demo")
    public String logDemo() {
        String str = "success";
        logger.info("this is log demo");
        return str;
    }

}

