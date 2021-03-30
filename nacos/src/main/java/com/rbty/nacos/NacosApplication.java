package com.rbty.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RequestMapping("/config")
@RefreshScope
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

    @Value("${test}")
    private String test;
    /*@Value("${share-config1}")
    private String config1;*/
    @Value("${share-config2}")
    private String config2;

    @RequestMapping("/get")
    public String get() {
        /*System.out.println(config1);*/
        System.out.println(config2);
        return test;
    }

}
