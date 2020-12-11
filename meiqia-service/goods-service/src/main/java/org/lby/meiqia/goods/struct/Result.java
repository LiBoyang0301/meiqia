package org.lby.meiqia.goods.struct;

import java.io.Serializable;

// 结果集
public class Result<T> implements Serializable {
    // 状态
    private boolean flag;
    // 状态码
    private int code;
    // 解释信息
    private String msg;
    // 信息体
    private T body;

    public static Result ok() {
        return new Result(true, 200, "OK");
    }

    public static <T> Result ok(T body) {
        return new Result(true, 200, "OK", body);
    }

    public static Result error() {
        return new Result(false,500, "ERROR");
    }

    public Result(boolean flag, int code, String msg, T body) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public Result(boolean flag, int code, String msg) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
