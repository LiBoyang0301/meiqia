package org.lby.meiqia.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 交易明细
 * </p>
 *
 * @author jiusan
 * @since 2020-12-09
 */
@TableName("t_balance_trade")
public class BalanceTrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 借贷：1为借（收入 充值），0为贷（支出 消费）
     */
    @TableField("debit")
    private Integer debit;

    /**
     * 发生数额
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 余额
     */
    @TableField("balance")
    private Integer balance;

    /**
     * 摘要、备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 最后发生时间
     */
    @TableField("created")
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "BalanceTrade{" +
            "id=" + id +
            ", userId=" + userId +
            ", orderNo=" + orderNo +
            ", debit=" + debit +
            ", amount=" + amount +
            ", balance=" + balance +
            ", remark=" + remark +
            ", created=" + created +
        "}";
    }
}
