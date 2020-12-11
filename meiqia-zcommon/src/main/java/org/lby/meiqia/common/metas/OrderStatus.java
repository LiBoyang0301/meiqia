package org.lby.meiqia.common.metas;

public enum OrderStatus {
    WAIT_PAY("待支付"),
    PAY_SUCCESS("已支付"),
    PAY_FAILED("支付失败"),
    ;

    private String msg;

    OrderStatus(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
