package com.bobo.eureka.service;

import lombok.Data;

import java.util.Date;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/10下午5:53
 */
@Data
public class Product {

    private String id;
    private String name;
    private Float price;
    private Date created;
}
