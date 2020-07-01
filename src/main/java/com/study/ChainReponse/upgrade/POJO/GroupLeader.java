package com.study.ChainReponse.upgrade.POJO;

import com.study.ChainReponse.upgrade.Request;
import com.study.ChainReponse.upgrade.Result;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class GroupLeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("groupLead deal request===>"+request.toString());
        if (request.days() > 1) {
            Request newRequest = new Request.Builder().newRequest(request)
                .setGroupLeaderInfo(request.name()+", groupLeader info")
                .build();

            return chain.process(newRequest);
        }
        return new Result(true, "groupLead: good luck");
    }
}
