package org.lby.meiqia.user.service;

import org.lby.meiqia.user.entity.Balance;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.vo.SearchVO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户余额 服务类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
public interface BalanceService extends IService<Balance> {

    /**
    * 分页列表查询
    * @param currPage
    * @param pageSize
    * @param vo
    * @return
    */
    PageResult<Balance> page(Integer currPage, Integer pageSize, SearchVO vo);

    /**
    * 添加用户余额
    * @param balance
    * @return
    */
    boolean saveBalance(Balance balance);

    /**
    * 修改用户余额
    * @param balance
    * @return
    */
    boolean updateBalance(Balance balance);

    /**
    * 根据ID删除用户余额
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

    Balance getByUserId(Long userId);
}
