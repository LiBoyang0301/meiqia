package org.lby.meiqia.goods.vo;

import java.io.Serializable;

/**
 * 查询条件
 */
public class SearchVO implements Serializable {
    // 关键字查询
    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
