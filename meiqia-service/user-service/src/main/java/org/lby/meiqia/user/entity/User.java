package org.lby.meiqia.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 盐值
     */
    @TableField("salt")
    private String salt;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 角色
     */
    @TableField("role")
    private Integer role;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name=" + name +
            ", mobile=" + mobile +
            ", password=" + password +
            ", salt=" + salt +
            ", status=" + status +
            ", role=" + role +
            ", nickname=" + nickname +
            ", createTime=" + createTime +
            ", lastLoginTime=" + lastLoginTime +
        "}";
    }
}
