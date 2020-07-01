package com.study.controller.lookup;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author xinfei.wang on 2019/10/16.
 */
public class Main {

    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-test.xml"));
        GetBeanTest bean = (GetBeanTest)xmlBeanFactory.getBean("getBean");
//        ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext("classpath:spring-test.xml");
//        GetBeanTest bean = (GetBeanTest)content.getBean("getBean");
        bean.show();

        String str = "sdf;,b,ad;sss,;";
        String[] ss = StringUtils.tokenizeToStringArray(str, ",;");
        for (String s : ss) {
            System.out.println(s);
        }
        System.out.println(ss.length);
    }
}
