package com.study.ChainReponse.upgrade.POJO;

import com.study.ChainReponse.upgrade.Request;
import com.study.ChainReponse.upgrade.Result;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class ManagerLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("manage deal info====>"+request);
        if (request.days() > 3) {
            Request newRequest = new Request.Builder()
                .newRequest(request)
                .setManagerInfo(request.name() + ",manager info")
                .build();
            return chain.process(newRequest);
        }
        return new Result(true, "manager message");
    }
}
