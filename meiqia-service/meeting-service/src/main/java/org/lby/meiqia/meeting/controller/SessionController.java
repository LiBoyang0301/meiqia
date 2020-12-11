package org.lby.meiqia.meeting.controller;


import org.lby.meiqia.meeting.entity.Session;
import org.lby.meiqia.meeting.service.SessionService;
import org.lby.meiqia.meeting.struct.PageResult;
import org.lby.meiqia.meeting.struct.Result;
import org.lby.meiqia.meeting.vo.SearchVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/session")
public class SessionController {
    @Resource
	private SessionService sessionService;

    @GetMapping("/{id}")
    public Result<Session> getById(@PathVariable("id") Long id) {
        return Result.ok(sessionService.getById(id));
    }

    @GetMapping
    public Result<List<Session>> list() {
        return Result.ok(sessionService.list());
    }

    @PostMapping
    public Result add(@RequestBody Session session) {
        return sessionService.saveSession(session) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Session session) {
        return sessionService.updateSession(session) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return sessionService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<Session>> page(@PathVariable("currPage") Integer currPage,
                                            @PathVariable("pageSize") Integer pageSize,
                                            @RequestBody(required = false) SearchVO vo) {
        return Result.ok(sessionService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return sessionService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
