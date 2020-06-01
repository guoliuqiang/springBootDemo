package com.lhosdp.demo.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author guoliuqaing
 */
@Mapper
public interface OrderMapper {

    /**
     * 类型转换
     * @param order
     * @return
     */
    @Mapping(source = "createTime", target = "startTime")
    @Mapping(source = "subSource", target = "subTarget")
    OrderQueryParam entity2queryParam(Order order);

    /**
     * 支持自定义对象的转换
     * @param subSource
     * @return
     */
    default SubTarget subSource2subTarget(SubSource subSource) {
        if (subSource == null) {
            return null;
        }
        SubTarget subTarget = new SubTarget();
        subTarget.setResult(!subSource.getDeleted().equals(0));
        subTarget.setName(subSource.getName() == null ? "" : subSource.getName());
        return subTarget;
    }
}
