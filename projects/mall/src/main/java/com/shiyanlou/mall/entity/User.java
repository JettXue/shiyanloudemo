package com.shiyanlou.mall.entity;/**
 * @Author jettx
 * @Date 3/24/2020 3:48 PM
 */

import lombok.Data;
import lombok.ToString;

/**
 * @author Jettx
 * @date 3/24/2020 3:48 PM
 */
@Data
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
}
