package com.niocoder.niocoder.service.channel;

import com.niocoder.niocoder.Enum.AnimalEnum;

public abstract class AbstractAnimalService {

    public boolean isPet(AnimalEnum animalEnum){
        if(animalEnum == AnimalEnum.ANIMAL_DOG)
            return true;
        else if(animalEnum == AnimalEnum.ANIMAL_CAT)
            return true;
        else
            return false;
    }
}
