package com.lhosdp.demo.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author guoliuqaing
 * 使用依赖注入
 * 值 	    注入方式
 * default 	默认的方式， 使用 Mappers.getMapper(Class) 来进行获取 Mapper
 * cdi 	    Contexts and Dependency Injection. 使用此种方式， 需要使用 @Inject 来进行注入
 * spring 	Spring 的方式， 可以通过 @Autowired 来进行注入
 * jsr330 	生成的 Mapper 中， 使用 @javax.inject.Named 和 @Singleton 注解, 通过 @Inject 来注入
 * componentModel = "spring" 生成的映射器是一个单一范围的spring bean
 * unmappedTargetPolicy = ReportingPolicy.IGNORE   未映射的目标属性被忽略
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
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
