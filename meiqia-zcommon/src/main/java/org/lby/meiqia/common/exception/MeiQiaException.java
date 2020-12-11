package org.lby.meiqia.common.exception;

public class MeiQiaException extends RuntimeException {
    private int code;
    private String msg;
    public MeiQiaException(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MeiQiaException() {
        super();
    }

    public MeiQiaException(String message) {
        super(message);
        this.msg = message;
    }

    public MeiQiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeiQiaException(Throwable cause) {
        super(cause);
    }

    protected MeiQiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
