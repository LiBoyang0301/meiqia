package org.lby.meiqia.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_patient")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Long userId;

    @TableField("idcard")
    private String idcard;

    @TableField("high")
    private String high;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Patient{" +
            "userId=" + userId +
            ", idcard=" + idcard +
            ", high=" + high +
        "}";
    }
}
