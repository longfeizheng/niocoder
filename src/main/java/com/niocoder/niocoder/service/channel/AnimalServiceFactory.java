package com.niocoder.niocoder.service.channel;

import com.niocoder.niocoder.Enum.AnimalEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AnimalServiceFactory implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    public AbstractAnimalService getAnimalService(String animalCode) {

        String animaleName = AnimalEnum.getName(animalCode);

        if (StringUtils.isEmpty(animaleName)) {
            throw new RuntimeException("找不到对应的动物service");
        }

        return (AbstractAnimalService) applicationContext.getBean(animaleName + "ServiceImpl");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
