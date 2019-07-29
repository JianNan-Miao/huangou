package com.cheer.huangou.item.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HuangouItemService {
    public static void main(String[] args) {
        SpringApplication.run(HuangouItemService.class, args);
    }
}
