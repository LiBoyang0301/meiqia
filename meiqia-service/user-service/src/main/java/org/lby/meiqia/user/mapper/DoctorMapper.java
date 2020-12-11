package org.lby.meiqia.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import feign.Param;
import org.lby.meiqia.user.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lby.meiqia.user.vo.DoctorVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

    Page<DoctorVO> page(Page<DoctorVO> doctorPage, @Param("ew") QueryWrapper<DoctorVO> wrapper);
}
