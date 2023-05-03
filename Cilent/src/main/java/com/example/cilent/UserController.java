package com.example.cilent;


import com.example.Feign.ProductFeginClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    ProductFeginClient productFeginClient;
//    private RestTemplate restTemplate;
    @GetMapping("/findOrdersByUser/{id}")
    @HystrixCommand(fallbackMethod = "fallbackInfo")
//    public String findOrdersByUser(@PathVariable String id) {
//        return this.restTemplate.getForObject("http://microservice-eureka-order/order/" + id, String.class);
//    }
    public String findOrdersByUser(@PathVariable String id) {
        return productFeginClient.findOrdersByUser(id);
    }

    public String fallbackInfo(@PathVariable String id){
        return "服务不可用，请稍后再试！";
    }
}
