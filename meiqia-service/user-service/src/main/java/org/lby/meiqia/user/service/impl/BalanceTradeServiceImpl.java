package org.lby.meiqia.user.service.impl;

import org.lby.meiqia.user.entity.BalanceTrade;
import org.lby.meiqia.user.mapper.BalanceTradeMapper;
import org.lby.meiqia.user.service.BalanceTradeService;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.vo.SearchVO;
import org.lby.meiqia.user.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;
import java.util.List;

/**
 * <p>
 * 交易明细 服务实现类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-09
 */
@Service
public class BalanceTradeServiceImpl extends ServiceImpl<BalanceTradeMapper, BalanceTrade> implements BalanceTradeService {

    @Override
    public PageResult<BalanceTrade> page(Integer currPage, Integer pageSize, SearchVO vo) {
        // 分页
        Page<BalanceTrade> balanceTradePage = new Page<>(currPage, pageSize);

        // 条件查询
        QueryWrapper<BalanceTrade> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(vo)) {
            String keyWord = vo.getKeyWord();
            if (StringUtils.isNotEmpty(keyWord)) {
                wrapper.like("name", keyWord);
            }
        }
        balanceTradePage = page(balanceTradePage, wrapper);
        return PageResult.of(balanceTradePage.getRecords(), balanceTradePage.getTotal());
    }

    @Override
    public boolean saveBalanceTrade(BalanceTrade balanceTrade) {
        return save(balanceTrade);
    }

    @Override
    public boolean updateBalanceTrade(BalanceTrade balanceTrade) {
        return updateById(balanceTrade);
    }

    @Override
    public boolean delById(Long id) {
        return removeById(id);
    }

    @Override
    public boolean delByIds(List<Long> ids) {
        return removeByIds(ids);
    }

    @Override
    public BalanceTrade getLastRecord(Long userId) {
        QueryWrapper<BalanceTrade> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.orderByDesc("created");
        List<BalanceTrade> list = list(wrapper);
        return list.get(0);
    }
}
