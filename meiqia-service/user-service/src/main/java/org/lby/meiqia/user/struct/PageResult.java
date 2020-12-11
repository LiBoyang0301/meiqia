package org.lby.meiqia.user.struct;

import java.io.Serializable;
import java.util.List;

// 分页结果集
public class PageResult<T> implements Serializable {
    // 当前页数据
    private List<T> rows;
    // 总条目数
    private long total;
    // 无参构造
    public PageResult() {
    }
    // 有参构造
    public PageResult(List<T> rows, long total) {
        this.rows = rows;
        this.total = total;
    }
    // of方法构造对象
    public static <T> PageResult<T> of(List<T> rows, long total){
        return new PageResult<T>(rows,total);
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
