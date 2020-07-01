package com.study.controller.lookup;

/**
 * @author xinfei.wang on 2019/10/16.
 */
public class Student implements User {

    @Override
    public void showMe() {
        System.out.println("i am student");
    }
}
