package com.niocoder.niocoder.service.channel;

import com.niocoder.niocoder.Enum.AnimalEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractAnimalServiceTest {

    @Autowired
    private AnimalServiceFactory animalServiceFactory;

    @Test
    public void isPet() {
        AbstractAnimalService animalService = animalServiceFactory.getAnimalService("1");
        if (animalService.isPet(AnimalEnum.codeOf("1"))) {
            IVoiceAble voiceAble = (IVoiceAble) animalService;
            voiceAble.voice();
        }
    }
}