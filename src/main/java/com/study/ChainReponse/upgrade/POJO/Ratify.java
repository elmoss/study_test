package com.study.ChainReponse.upgrade.POJO;

import com.study.ChainReponse.upgrade.Request;
import com.study.ChainReponse.upgrade.Result;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public interface Ratify {

    Result deal(Chain chain);

    interface Chain{

        Request request();
        Result process(Request request);

    }
}
