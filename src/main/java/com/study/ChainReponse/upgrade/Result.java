package com.study.ChainReponse.upgrade;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class Result {
    private Boolean ratify;
    private String msg;

    public Result(Boolean ratify, String msg) {
        this.ratify = ratify;
        this.msg = msg;
    }

    public Boolean getRatify() {
        return ratify;
    }

    public void setRatify(Boolean ratify) {
        this.ratify = ratify;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
            "ratify=" + ratify +
            ", msg='" + msg + '\'' +
            '}';
    }
}
