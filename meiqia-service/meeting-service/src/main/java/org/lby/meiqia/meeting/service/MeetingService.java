package org.lby.meiqia.meeting.service;

import org.lby.meiqia.meeting.entity.Meeting;
import org.lby.meiqia.meeting.struct.PageResult;
import org.lby.meiqia.meeting.vo.SearchVO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会诊记录表 服务类
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
public interface MeetingService extends IService<Meeting> {

    /**
    * 分页列表查询
    * @param currPage
    * @param pageSize
    * @param vo
    * @return
    */
    PageResult<Meeting> page(Integer currPage, Integer pageSize, SearchVO vo);

    /**
    * 添加会诊记录表
    * @param meeting
    * @return
    */
    boolean saveMeeting(Meeting meeting);

    /**
    * 修改会诊记录表
    * @param meeting
    * @return
    */
    boolean updateMeeting(Meeting meeting);

    /**
    * 根据ID删除会诊记录表
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
