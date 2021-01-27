package com.lhosdp.demo.controller;

import com.lhosdp.demo.mapstruct.Order;
import com.lhosdp.demo.mapstruct.OrderMapper;
import com.lhosdp.demo.mapstruct.OrderQueryParam;
import com.lhosdp.demo.mapstruct.SubSource;
import com.lhosdp.demo.mapstruct.muchtoone.Address;
import com.lhosdp.demo.mapstruct.muchtoone.DeliveryAddress;
import com.lhosdp.demo.mapstruct.muchtoone.DeliveryAddressMapper;
import com.lhosdp.demo.mapstruct.muchtoone.Person;
import com.lhosdp.demo.mybatisplus.User;
import com.lhosdp.demo.mybatisplus.UserMapper;
import org.junit.Assert;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author guoliuqaing
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private OrderMapper orderMapper;


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
//        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = orderMapper.entity2queryParam(order);
        return orderQueryParam;

    }

    @RequestMapping(value = "/DeliveryAddressMapper", method = RequestMethod.POST)
    public DeliveryAddress deliveryAddressMapper(){
        Person person = new Person();
        person.setDescription("persiondescription");
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setHeight(10);
        Address address = new Address();
        address.setDescription("addresssdescription");
        address.setHouseNo(20);
        address.setStreet("street");
        address.setZipCode(00001);

        DeliveryAddress deliveryAddress1 = DeliveryAddressMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person, address);
        Address address2 = new Address();
        address2.setDescription("北京市昌平区回龙观总政小区7号楼1单元902");
        address2.setHouseNo(20);
        address2.setStreet("updatestreet");
        address2.setZipCode(9999);

        DeliveryAddressMapper.INSTANCE.updateDeliveryAddressFromAddress(address2, deliveryAddress1);

        return deliveryAddress1;

    }

    @RequestMapping("/getTime")
    public String getTime(){
        return System.currentTimeMillis() + "";
    }
}
