package org.lby.meiqia.goods.service.impl;

import org.lby.meiqia.goods.entity.Goods;
import org.lby.meiqia.goods.mapper.GoodsMapper;
import org.lby.meiqia.goods.service.GoodsService;
import org.lby.meiqia.goods.struct.PageResult;
import org.lby.meiqia.goods.vo.SearchVO;
import org.lby.meiqia.goods.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public PageResult<Goods> page(Integer currPage, Integer pageSize, SearchVO vo) {
        // 分页
        Page<Goods> goodsPage = new Page<>(currPage, pageSize);

        // 条件查询
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(vo)) {
            String keyWord = vo.getKeyWord();
            if (StringUtils.isNotEmpty(keyWord)) {
                wrapper.like("name", keyWord);
            }
        }
        goodsPage = page(goodsPage, wrapper);
        return PageResult.of(goodsPage.getRecords(), goodsPage.getTotal());
    }

    @Override
    public boolean saveGoods(Goods goods) {
        return save(goods);
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return updateById(goods);
    }

    @Override
    public boolean delById(Long id) {
        return removeById(id);
    }

    @Override
    public boolean delByIds(List<Long> ids) {
        return removeByIds(ids);
    }
}
