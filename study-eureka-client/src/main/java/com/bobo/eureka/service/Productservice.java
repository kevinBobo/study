package com.bobo.eureka.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/11下午2:03
 */
@FeignClient("eureka-client2")
public interface Productservice {

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable("id")String id);
}
