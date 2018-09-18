package eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eureka.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/10下午5:52
 */
@RestController
public class ProductController {

    @GetMapping("/product/{id}")
    @HystrixCommand
    public Product getProduct(@PathVariable("id")String id){
        Product product = new Product();
        product.setId(id);
        product.setName("测试商品3");
        product.setCreated(new Date());
        product.setPrice(1200f);
        return product;
    }
}
