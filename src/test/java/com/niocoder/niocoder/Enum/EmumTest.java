package com.niocoder.niocoder.Enum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmumTest {

    @Test
    public void testEnum() throws Exception {
        AnimalEnum animalEnum = AnimalEnum.codeOf("1");
        String str = AnimalEnum.getId("animalDog");
        String str1 = AnimalEnum.getName("1");
        System.out.println(animalEnum + "," + str + "," + str1);
    }
}
