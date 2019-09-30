package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/random-int")
    public Map<String, Object>  getInt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        Map<String, Object> m = new HashMap<>(16);
        Date d = new Date();
        System.out.println(sdf.format(d));
        m.put("year", d.getYear());
        m.put("month", d.getMonth());
        m.put("day", d.getDay());
        m.put("second", d.getSeconds());
        return m;
    }

}

