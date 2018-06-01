package com.niocoder.niocoder.consumer.start;

import com.niocoder.niocoder.consumer.rpc.RpcConsumer;
import com.niocoder.niocoder.provider.service.BatterCakeService;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class RpcTest {
    public static void main(String[] args) {
        BatterCakeService batterCakeService= RpcConsumer.getService(BatterCakeService.class, "127.0.0.1", 20006);
        String result=batterCakeService.sellBatterCake("双蛋");
        System.out.println(result);
    }
}
