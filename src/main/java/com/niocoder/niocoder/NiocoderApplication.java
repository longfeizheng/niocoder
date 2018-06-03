package com.niocoder.niocoder;

import com.niocoder.niocoder.zookeeper.ZkClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NiocoderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NiocoderApplication.class, args);
        ZkClient zkClient = context.getBean(ZkClient.class);
        zkClient.register();
    }
}
