package com.study.ChainReponse;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public abstract class AbstractLog {
    public static int ERROR = 2;
    public static int DEBUG = 1;
    public static int INFO = 0;

    public AbstractLog next;
    public int LEVEL;

    public void nextLog(AbstractLog next) {
        this.next = next;
    }

    public void checkLog(int level, String msg) {
        if (level <= this.LEVEL) {
            write(msg);
        }
        if (next != null) {
            next.checkLog(level, msg);
        }
    }

    public abstract void write(String msg);

}
