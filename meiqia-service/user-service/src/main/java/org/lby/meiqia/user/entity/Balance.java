package org.lby.meiqia.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户余额
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@TableName("t_balance")
public class Balance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户
     */
    @TableId("user_id")
    private Long userId;

    /**
     * 余额值
     */
    @TableField("amounts")
    private Integer amounts;

    /**
     * 余额变动校验码
     */
    @TableField("checksum")
    private String checksum;

    /**
     * 锁定资金账户 1:true 0:false
     */
    @TableField("locked")
    private Integer locked;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }
    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer updateBalance(Integer amount,Integer debit){
        if(debit==1){
            this.amounts += amount;
        }else {
            this.amounts-=amount;
        }
        return this.amounts;
    }

    @Override
    public String toString() {
        return "Balance{" +
            "userId=" + userId +
            ", amounts=" + amounts +
            ", checksum=" + checksum +
            ", locked=" + locked +
        "}";
    }
}
