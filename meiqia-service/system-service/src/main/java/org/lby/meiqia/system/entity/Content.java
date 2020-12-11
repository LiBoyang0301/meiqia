package org.lby.meiqia.system.entity;

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
 * @since 2020-12-09
 */
@TableName("t_content")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 图片地址
     */
    @TableField("pic")
    private String pic;

    /**
     * 跳转连接
     */
    @TableField("url")
    private String url;

    /**
     * 状态
     */
    @TableField("status")
    private Boolean status;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Content{" +
            "id=" + id +
            ", title=" + title +
            ", pic=" + pic +
            ", url=" + url +
            ", status=" + status +
            ", sort=" + sort +
        "}";
    }
}
