package org.lby.meiqia.user.service.impl;

import org.lby.meiqia.user.entity.Doctor;
import org.lby.meiqia.user.mapper.DoctorMapper;
import org.lby.meiqia.user.service.DoctorService;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.vo.DoctorVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    @Override
    public PageResult<DoctorVO> page(Integer currPage, Integer pageSize, Long roomId) {
        // 分页
        Page<DoctorVO> doctorPage = new Page<>(currPage, pageSize);
        // 条件查询
        QueryWrapper<DoctorVO> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(roomId)) {

            wrapper.eq("roomId", roomId);
        }
        //doctorPage = baseMapper.page(doctorPage, wrapper);


        // 查询用户信息




        return PageResult.of(doctorPage.getRecords(), doctorPage.getTotal());
    }

    @Override
    public boolean saveDoctor(Doctor doctor) {
        return save(doctor);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return updateById(doctor);
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
