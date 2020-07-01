package com.study.ChainReponse.upgrade;

import com.study.ChainReponse.upgrade.POJO.DepartmentLeader;
import com.study.ChainReponse.upgrade.POJO.GroupLeader;
import com.study.ChainReponse.upgrade.POJO.ManagerLeader;
import com.study.ChainReponse.upgrade.POJO.Ratify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class ChainOfResponseClient {
    List<Ratify> ratifies;

    public ChainOfResponseClient() {
        ratifies = new ArrayList<>();
        ratifies.add(new GroupLeader());
        ratifies.add(new ManagerLeader());
        ratifies.add(new DepartmentLeader());
    }

    public void addRatify(Ratify ratify) {
        ratifies.add(ratify);
    }

    public Result execute(Request request) {
        RealChain realChain = new RealChain(request, ratifies, 0);
        Result process = realChain.process(request);
        return process;
    }
}
