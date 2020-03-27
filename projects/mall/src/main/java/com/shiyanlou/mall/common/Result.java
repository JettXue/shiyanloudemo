package com.shiyanlou.mall.common;/**
 * @Author jettx
 * @Date 3/24/2020 9:37 PM
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jettx
 * @date 3/24/2020 9:37 PM
 */
@Data
public class Result<T> implements Serializable {
    private static final long seriaVersionUID = 1L;

    private int resultCode;

    private String message;

    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
