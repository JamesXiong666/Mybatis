package com.james.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//代表getter,setter
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@ToString//tosstring的注解
public class Student {
    //属性名和列名一样
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}


