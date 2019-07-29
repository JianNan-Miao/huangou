package com.cheer.huangou.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HuangouRegistry {
    public static void main(String[] args) {
        SpringApplication.run(HuangouRegistry.class, args);
    }
}
