package com.bobo.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/12下午2:19
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class RabbitStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitStreamApplication.class);
    }

    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "5000"))
    public String createMessage() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


}
