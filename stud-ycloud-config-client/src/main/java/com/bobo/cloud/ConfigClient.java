package com.bobo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/10下午7:27
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class);
    }
}
