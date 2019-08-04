package com.cheer.huangou.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:server.port.properties")
@SpringBootApplication
@EnableDiscoveryClient
public class HuanGouUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuanGouUploadApplication.class);
    }
}
