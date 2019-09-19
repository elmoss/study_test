package com.study.controller;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author xinfei.wang on 2019/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml"})
public class DemeMappingTest {

    @Test
    public void logDemo() throws Exception{
        Logger logger = LoggerFactory.getLogger(DemeMappingTest.class);
        logger.info("aa d");
        System.out.println("demo test");
        //jdk
        java.util.logging.Logger l = java.util.logging.Logger.getLogger(DemeMapping.class.getName());
        l.info("jdk log");
        //log4j
        org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("s");
        PropertyConfigurator.configure(new URL(""));
        logger1.info("message info");
    }

}