package com.lhosdp.demo.mapstruct;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T16:57:38+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_77 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderQueryParam entity2queryParam(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderQueryParam orderQueryParam = new OrderQueryParam();

        orderQueryParam.setSubTarget( subSource2subTarget( order.getSubSource() ) );
        orderQueryParam.setStartTime( order.getCreateTime() );
        orderQueryParam.setOrderSn( order.getOrderSn() );
        orderQueryParam.setReceiverKeyword( order.getReceiverKeyword() );
        orderQueryParam.setStatus( order.getStatus() );
        orderQueryParam.setOrderType( order.getOrderType() );
        orderQueryParam.setSourceType( order.getSourceType() );

        return orderQueryParam;
    }
}
