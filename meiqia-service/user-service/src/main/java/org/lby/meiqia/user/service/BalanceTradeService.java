package org.lby.meiqia.user.service;

import org.lby.meiqia.user.entity.BalanceTrade;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.vo.SearchVO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 交易明细 服务类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-09
 */
public interface BalanceTradeService extends IService<BalanceTrade> {

    /**
    * 分页列表查询
    * @param currPage
    * @param pageSize
    * @param vo
    * @return
    */
    PageResult<BalanceTrade> page(Integer currPage, Integer pageSize, SearchVO vo);

    /**
    * 添加交易明细
    * @param balanceTrade
    * @return
    */
    boolean saveBalanceTrade(BalanceTrade balanceTrade);

    /**
    * 修改交易明细
    * @param balanceTrade
    * @return
    */
    boolean updateBalanceTrade(BalanceTrade balanceTrade);

    /**
    * 根据ID删除交易明细
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

    BalanceTrade getLastRecord(Long userId);
}
