package com.study.ChainReponse.upgrade.POJO;

import com.study.ChainReponse.upgrade.Request;
import com.study.ChainReponse.upgrade.Result;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class DepartmentLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("departmentLeader deal info====>"+request);
        if (request.days() > 7) {
            return new Result(false, "no ,it's to long");
        }
        return new Result(true, "departmentLeader info");
    }
}
