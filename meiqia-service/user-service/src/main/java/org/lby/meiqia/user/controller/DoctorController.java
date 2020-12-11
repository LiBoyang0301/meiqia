package org.lby.meiqia.user.controller;


import org.lby.meiqia.user.vo.DoctorVO;
import org.lby.meiqia.user.entity.Doctor;
import org.lby.meiqia.user.service.DoctorService;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.struct.Result;
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
@RequestMapping("/doctor")
public class DoctorController {
    @Resource
	private DoctorService doctorService;

    @GetMapping("/{id}")
    public Result<Doctor> getById(@PathVariable("id") Long id) {
        return Result.ok(doctorService.getById(id));
    }

    @GetMapping
    public Result<List<Doctor>> list() {
        return Result.ok(doctorService.list());
    }

    @PostMapping
    public Result add(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return doctorService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}/{roomId}")
    public Result<PageResult<DoctorVO>> page(@PathVariable("currPage") Integer currPage,
                                             @PathVariable("pageSize") Integer pageSize,
                                             @PathVariable("roomId") Long roomId) {
        return Result.ok(doctorService.page(currPage, pageSize, roomId));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return doctorService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
