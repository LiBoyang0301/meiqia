package org.lby.meiqia.goods.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 状态（上架0/下架1）
     */
    @TableField("status")
    private Boolean status;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 商品名
     */
    @TableField("name")
    private String name;

    /**
     * 商品详情
     */
    @TableField("details")
    private String details;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 优惠
     */
    @TableField("discount")
    private BigDecimal discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "id=" + id +
            ", status=" + status +
            ", stock=" + stock +
            ", name=" + name +
            ", details=" + details +
            ", price=" + price +
            ", discount=" + discount +
        "}";
    }
}
