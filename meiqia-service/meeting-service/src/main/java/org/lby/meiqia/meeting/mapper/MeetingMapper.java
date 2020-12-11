package org.lby.meiqia.meeting.mapper;

import org.lby.meiqia.meeting.entity.Meeting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会诊记录表 Mapper 接口
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@Mapper
public interface MeetingMapper extends BaseMapper<Meeting> {

}
