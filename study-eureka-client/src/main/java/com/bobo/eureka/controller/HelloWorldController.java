package com.bobo.eureka.controller;

import com.bobo.eureka.service.Product;
import com.bobo.eureka.service.Productservice;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/10下午4:19
 */
@RestController
public class HelloWorldController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Productservice productservice;

    @RequestMapping("/")
    public String helloworld(){
        return "hello world";
    }

    @RequestMapping("/getServer")
    public Object getServer(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-client",false);
        return instanceInfo.getHostName();
    }

    @RequestMapping("getInstances")
    public Object getInstances(){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        return instances;
    }

    @GetMapping("/productInfo/{id}")
    public Object getProductInfo(@PathVariable("id")String id){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client2");
        String url = instances.get(0).getUri().toString();
        Object forObject = restTemplate.getForObject(url + "/product/" + id, Object.class);
        return forObject;
    }

    @GetMapping("/loadBalanceProductInfo/{id}")
    @HystrixCommand(fallbackMethod = "testError")
    public Object loadBalanceProductInfo(@PathVariable("id")String id){
//        Object forObject = restTemplate.getForObject("http://eureka-client2/product/" + id, Object.class);
        Product product = productservice.getProduct(id);
        return product;
    }

    public String testError(String id){
        return "histrix error is fallback";
    }
}
