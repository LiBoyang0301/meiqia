package org.lby.meiqia.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private String orderId;

    @TableField("user_id")
    private Long userId;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 收货人
     */
    @TableField("consignee")
    private String consignee;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 商品详情
     */
    @TableField("product_details")
    private String productDetails;

    /**
     * 数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 状态
     */
    @TableField("status")
    private Boolean status;

    /**
     * 支付方式
     */
    @TableField("payment")
    private Boolean payment;

    @TableField("create_time")
    private Date createTime;

    @TableField("pay_time")
    private Date payTime;

    @TableField("type")
    private Boolean type;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", price=" + price +
            ", consignee=" + consignee +
            ", phone=" + phone +
            ", productDetails=" + productDetails +
            ", num=" + num +
            ", status=" + status +
            ", payment=" + payment +
            ", createTime=" + createTime +
            ", payTime=" + payTime +
            ", type=" + type +
        "}";
    }
}
