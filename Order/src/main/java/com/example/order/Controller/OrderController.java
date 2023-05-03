package com.example.order.Controller;

import com.example.order.Config.ServiceInfoUtil;
import com.example.order.entiy.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/order/{id}")
    public String findOderById(@PathVariable String id){
        Order order=new Order();
        order.setId("123");
        order.setPrice(21.0);
        order.setName("陈相陵");
        order.setXuehao("202010098220");
        System.out.println(ServiceInfoUtil.getPort());
        return order.toString();
    }
}
