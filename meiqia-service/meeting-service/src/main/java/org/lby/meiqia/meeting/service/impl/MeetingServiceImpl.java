package org.lby.meiqia.meeting.service.impl;

import org.lby.meiqia.meeting.entity.Meeting;
import org.lby.meiqia.meeting.mapper.MeetingMapper;
import org.lby.meiqia.meeting.service.MeetingService;
import org.lby.meiqia.meeting.struct.PageResult;
import org.lby.meiqia.meeting.vo.SearchVO;
import org.lby.meiqia.meeting.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;
import java.util.List;

/**
 * <p>
 * 会诊记录表 服务实现类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting> implements MeetingService {

    @Override
    public PageResult<Meeting> page(Integer currPage, Integer pageSize, SearchVO vo) {
        // 分页
        Page<Meeting> meetingPage = new Page<>(currPage, pageSize);

        // 条件查询
        QueryWrapper<Meeting> wrapper = new QueryWrapper<>();

        if (Objects.nonNull(vo)) {
            String keyWord = vo.getKeyWord();
            if (StringUtils.isNotEmpty(keyWord)) {
                wrapper.like("name", keyWord);
            }
        }
        meetingPage = page(meetingPage, wrapper);
        return PageResult.of(meetingPage.getRecords(), meetingPage.getTotal());
    }

    @Override
    public boolean saveMeeting(Meeting meeting) {
        return save(meeting);
    }

    @Override
    public boolean updateMeeting(Meeting meeting) {
        return updateById(meeting);
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
