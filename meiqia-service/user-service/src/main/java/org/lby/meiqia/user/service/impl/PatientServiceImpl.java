package org.lby.meiqia.user.service.impl;

import org.lby.meiqia.user.entity.Patient;
import org.lby.meiqia.user.mapper.PatientMapper;
import org.lby.meiqia.user.service.PatientService;
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
 *  服务实现类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Override
    public PageResult<Patient> page(Integer currPage, Integer pageSize, SearchVO vo) {
        // 分页
        Page<Patient> patientPage = new Page<>(currPage, pageSize);

        // 条件查询
        QueryWrapper<Patient> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(vo)) {
            String keyWord = vo.getKeyWord();
            if (StringUtils.isNotEmpty(keyWord)) {
                wrapper.like("name", keyWord);
            }
        }
        patientPage = page(patientPage, wrapper);
        return PageResult.of(patientPage.getRecords(), patientPage.getTotal());
    }

    @Override
    public boolean savePatient(Patient patient) {
        return save(patient);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return updateById(patient);
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
