package com.niocoder.niocoder.provider.service.impl;

import com.niocoder.niocoder.provider.service.BatterCakeService;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class BatterCakeServiceImpl implements BatterCakeService {
    @Override
    public String sellBatterCake(String name) {
        return name+"煎饼，卖的特别好";
    }
}
