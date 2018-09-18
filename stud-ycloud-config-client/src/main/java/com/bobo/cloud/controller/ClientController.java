package com.bobo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author bobo
 * @Description:
 * @date 2018/9/10下午7:29
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${helloworld}")
    private String helloworld;

    @RequestMapping("/")
    public String helloworld(){
        return helloworld;
    }
}
