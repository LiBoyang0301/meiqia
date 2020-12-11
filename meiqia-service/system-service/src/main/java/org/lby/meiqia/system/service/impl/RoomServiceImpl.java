package org.lby.meiqia.system.service.impl;

import org.lby.meiqia.system.entity.Room;
import org.lby.meiqia.system.mapper.RoomMapper;
import org.lby.meiqia.system.service.RoomService;
import org.lby.meiqia.system.struct.PageResult;
import org.lby.meiqia.system.vo.SearchVO;
import org.lby.meiqia.system.util.StringUtils;
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
 * @since 2020-12-09
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Override
    public PageResult<Room> page(Integer currPage, Integer pageSize, SearchVO vo) {
        // 分页
        Page<Room> roomPage = new Page<>(currPage, pageSize);

        // 条件查询
        QueryWrapper<Room> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(vo)) {
            String keyWord = vo.getKeyWord();
            if (StringUtils.isNotEmpty(keyWord)) {
                wrapper.like("name", keyWord);
            }
        }
        roomPage = page(roomPage, wrapper);
        return PageResult.of(roomPage.getRecords(), roomPage.getTotal());
    }

    @Override
    public boolean saveRoom(Room room) {
        return save(room);
    }

    @Override
    public boolean updateRoom(Room room) {
        return updateById(room);
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
