package com.niocoder.niocoder.provider.start;

import com.niocoder.niocoder.provider.rpc.RpcProvider;
import com.niocoder.niocoder.provider.service.BatterCakeService;
import com.niocoder.niocoder.provider.service.impl.BatterCakeServiceImpl;

import java.io.IOException;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class RpcBootStrap {
    public static void main(String[] args) throws IOException {
        BatterCakeService batterCakeService = new BatterCakeServiceImpl();
        RpcProvider.export(20006,batterCakeService);
    }
}
