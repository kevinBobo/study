package com.bobo.stream.input;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/13下午3:02
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class InputStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(InputStreamApplication.class);
    }

    @StreamListener(Sink.INPUT)
    public void message(String message){
        System.out.println("接收到消息: "+message);
    }
}
