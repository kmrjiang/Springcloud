package com.example.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="microservice-eureka-order")
public interface ProductFeginClient {
    //调用的请求路径
    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public String findOrdersByUser(@PathVariable("id") String id);

}
