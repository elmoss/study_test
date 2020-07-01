package com.study.controller.lookup;

/**
 * @author xinfei.wang on 2019/10/16.
 */
public abstract class GetBeanTest {

    public void show() {
        this.getBean().showMe();
    }


    public abstract User getBean();
}
