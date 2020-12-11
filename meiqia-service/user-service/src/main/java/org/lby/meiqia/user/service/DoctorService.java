package org.lby.meiqia.user.service;

import org.lby.meiqia.user.entity.Doctor;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.vo.DoctorVO;

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
public interface DoctorService extends IService<Doctor> {

    /**
    * 分页列表查询
    * @param currPage
    * @param pageSize
    * @param roomId
    * @return
    */
    PageResult<DoctorVO> page(Integer currPage, Integer pageSize, Long roomId);

    /**
    * 添加
    * @param doctor
    * @return
    */
    boolean saveDoctor(Doctor doctor);

    /**
    * 修改
    * @param doctor
    * @return
    */
    boolean updateDoctor(Doctor doctor);

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
