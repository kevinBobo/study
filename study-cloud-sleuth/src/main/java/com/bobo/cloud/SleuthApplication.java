package com.bobo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/11下午6:40
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class) ;
    }
}
