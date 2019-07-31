package com.cheer.huangou.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.cheer.huangou.item.mapper")
@PropertySource("classpath:server.port.properties")
@EnableDiscoveryClient
@SpringBootApplication
public class HuangouItemService {
    public static void main(String[] args) {
        SpringApplication.run(HuangouItemService.class, args);
    }
}
