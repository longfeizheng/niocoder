package com.niocoder.niocoder.service.channel.impl;

import com.niocoder.niocoder.service.channel.AbstractAnimalService;
import com.niocoder.niocoder.service.channel.IVoiceAble;
import org.springframework.stereotype.Service;

@Service(value = "animalCatServiceImpl")
public class AnimalCatServiceImpl extends AbstractAnimalService implements IVoiceAble {
    @Override
    public void voice() {
        System.out.println("喵喵喵");
    }
}
