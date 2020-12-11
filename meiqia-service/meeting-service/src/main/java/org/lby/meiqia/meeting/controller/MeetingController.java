package org.lby.meiqia.meeting.controller;


import org.lby.meiqia.meeting.entity.Meeting;
import org.lby.meiqia.meeting.service.MeetingService;
import org.lby.meiqia.meeting.struct.PageResult;
import org.lby.meiqia.meeting.struct.Result;
import org.lby.meiqia.meeting.vo.SearchVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import java.util.List;

/**
 * <p>
 * 会诊记录表 前端控制器
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Resource
	private MeetingService meetingService;

    @GetMapping("/{id}")
    public Result<Meeting> getById(@PathVariable("id") Long id) {
        return Result.ok(meetingService.getById(id));
    }

    @GetMapping
    public Result<List<Meeting>> list() {
        return Result.ok(meetingService.list());
    }

    @PostMapping
    public Result add(@RequestBody Meeting meeting) {
        return meetingService.saveMeeting(meeting) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Meeting meeting) {
        return meetingService.updateMeeting(meeting) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return meetingService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<Meeting>> page(@PathVariable("currPage") Integer currPage,
                                            @PathVariable("pageSize") Integer pageSize,
                                            @RequestBody(required = false) SearchVO vo) {
        return Result.ok(meetingService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return meetingService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
