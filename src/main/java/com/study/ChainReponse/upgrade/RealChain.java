package com.study.ChainReponse.upgrade;

import com.study.ChainReponse.upgrade.POJO.Ratify;

import java.util.List;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class RealChain implements Ratify.Chain {

    private Request request;
    private List<Ratify> list;
    private int index;

    public RealChain(Request request, List<Ratify> list, int index) {
        this.request = request;
        this.list = list;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Result process(Request request) {
        Result result = null;
        if (list.size() > index) {
            RealChain chain = new RealChain(request, list, index + 1);
            Ratify ratify = list.get(index);
            result = ratify.deal(chain);
        }
        return result;
    }
}
