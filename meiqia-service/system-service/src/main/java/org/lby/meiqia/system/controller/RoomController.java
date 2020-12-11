package org.lby.meiqia.system.controller;


import org.lby.meiqia.system.entity.Room;
import org.lby.meiqia.system.service.RoomService;
import org.lby.meiqia.system.struct.PageResult;
import org.lby.meiqia.system.struct.Result;
import org.lby.meiqia.system.vo.SearchVO;
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
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/room")
public class RoomController {
    @Resource
	private RoomService roomService;

    @GetMapping("/{id}")
    public Result<Room> getById(@PathVariable("id") Long id) {
        return Result.ok(roomService.getById(id));
    }

    @GetMapping
    public Result<List<Room>> list() {
        return Result.ok(roomService.list());
    }

    @PostMapping
    public Result add(@RequestBody Room room) {
        return roomService.saveRoom(room) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Room room) {
        return roomService.updateRoom(room) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return roomService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<Room>> page(@PathVariable("currPage") Integer currPage,
                                         @PathVariable("pageSize") Integer pageSize,
                                         @RequestBody(required = false) SearchVO vo) {
        return Result.ok(roomService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return roomService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
