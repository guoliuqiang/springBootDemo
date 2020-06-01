package com.lhosdp.demo.controller;

import com.lhosdp.demo.mapstruct.Order;
import com.lhosdp.demo.mapstruct.OrderMapper;
import com.lhosdp.demo.mapstruct.OrderQueryParam;
import com.lhosdp.demo.mapstruct.SubSource;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author guoliuqaing
 */
@RestController
public class HelloController {



    @RequestMapping(value = "/testOrder", method = RequestMethod.POST)
    public OrderQueryParam testOrder(){
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);
        order.setCreateTime(new Date());
        SubSource subSource = new SubSource();
        subSource.setDeleted(1);
        subSource.setName("guoliuqiang");
        order.setSubSource(subSource);
        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);
        return orderQueryParam;

    }

    @RequestMapping("/getTime")
    public String getTime(){
        return System.currentTimeMillis() + "";
    }
}
