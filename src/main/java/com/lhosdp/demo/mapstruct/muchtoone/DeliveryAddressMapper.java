package com.lhosdp.demo.mapstruct.muchtoone;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author guoliuqaing
 * 多转一操作
 */
@Mapper
public interface DeliveryAddressMapper {

    DeliveryAddressMapper INSTANCE = Mappers.getMapper(DeliveryAddressMapper.class);

    /**
     * 将person与Address对象转成address
     * @param person
     * @param address
     * @return
     */
    @Mapping(source = "person.description", target = "description")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddress personAndAddressToDeliveryAddressDto(Person person, Address address);


    /*

    在多对一转换时， 遵循以下几个原则

    当多个对象中， 有其中一个为 null， 则会直接返回 null
    如一对一转换一样， 属性通过名字来自动匹配。 因此， 名称和类型相同的不需要进行特殊处理
    当多个原对象中，有相同名字的属性时，需要通过 @Mapping 注解来具体的指定， 以免出现歧义（不指定会报错）。 如上面的 description
        @Mapping(source = "person.description", target = "description")
    @Mapping(source = "hn", target = "houseNumber")
    DeliveryAddress personAndAddressToDeliveryAddressDto(Person person, Integer hn);
    上面的例子中， hn 直接赋值给 houseNumber。
     */


    /**
     * 更新传入的deliveryAddress对象
     * 更新， 使用 Address 来更新 DeliveryAddress 信息。 注意注解 @MappingTarget
     * 注解 @MappingTarget后面跟的对象会被更新
     * @param address
     * @param deliveryAddress
     */
    void updateDeliveryAddressFromAddress(Address address, @MappingTarget DeliveryAddress deliveryAddress);


}
