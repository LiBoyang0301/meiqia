package org.lby.meiqia.goods.service;

import org.lby.meiqia.goods.entity.Goods;
import org.lby.meiqia.goods.struct.PageResult;
import org.lby.meiqia.goods.vo.SearchVO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
public interface GoodsService extends IService<Goods> {

    /**
    * 分页列表查询
    * @param currPage
    * @param pageSize
    * @param vo
    * @return
    */
    PageResult<Goods> page(Integer currPage, Integer pageSize, SearchVO vo);

    /**
    * 添加
    * @param goods
    * @return
    */
    boolean saveGoods(Goods goods);

    /**
    * 修改
    * @param goods
    * @return
    */
    boolean updateGoods(Goods goods);

    /**
    * 根据ID删除
    * @param id
    * @return
    */
    boolean delById(Long id);

    /**
    * 根据主键IDs批量删除
    * @param ids
    * @return
    */
    boolean delByIds(List<Long> ids);

}
