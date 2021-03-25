package com.ding.common;

import lombok.Data;

/**
 * @author dhr
 * @version 1.0.0
 * @ClassName Result.java
 * @Description TODO
 * @createTime 2021年03月25日 20:34:00
 * 统一结果封装
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(String msg,Object data){
        return new Result(200,msg,data);
    }

    public static Result error(int code,String msg){
        return new Result(code,msg,null);
    }

    public Result(Integer code,String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }
}
