package com.study.ChainReponse.upgrade;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class MainTest {

    public static void main(String[] args) {
        Request request = new Request.Builder()
            .setName("san")
            .setDays(5)
            .setReason("sick very").build();
        ChainOfResponseClient client = new ChainOfResponseClient();
        Result execute = client.execute(request);
        System.out.println("result: "+ execute);
    }
}
