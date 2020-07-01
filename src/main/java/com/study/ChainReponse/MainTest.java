package com.study.ChainReponse;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class MainTest {

    public static AbstractLog getChain() {
        AbstractLog error = new ErrorLog(AbstractLog.ERROR);
        AbstractLog debug = new DebugLog(AbstractLog.DEBUG);
        AbstractLog info = new InfoLog(AbstractLog.INFO);
        error.nextLog(debug);
        debug.nextLog(info);

        return error;
    }

    /**
     * 责任链模式，一次请求，多重判断
     * 主要思想：创建抽象接口，多个实现类，确定实现类的下一个链路，从第一链开始调用
     * @param args
     */
    public static void main(String[] args) {
        AbstractLog chain = getChain();

        chain.checkLog(AbstractLog.ERROR, "info message");
    }
}
