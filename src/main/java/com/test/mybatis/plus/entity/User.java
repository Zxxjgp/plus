package com.test.mybatis.plus.entity;

import com.test.mybatis.plus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}