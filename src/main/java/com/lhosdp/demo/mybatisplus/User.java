package com.lhosdp.demo.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guoliuqaing
 */
@Data
@TableName("user")
@NoArgsConstructor  //无参构造
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
