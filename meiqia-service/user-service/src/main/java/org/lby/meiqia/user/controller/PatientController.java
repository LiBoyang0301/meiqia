package org.lby.meiqia.user.controller;


import org.lby.meiqia.user.entity.Patient;
import org.lby.meiqia.user.service.PatientService;
import org.lby.meiqia.user.struct.PageResult;
import org.lby.meiqia.user.struct.Result;
import org.lby.meiqia.user.vo.SearchVO;
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
@RequestMapping("/patient")
public class PatientController {
    @Resource
	private PatientService patientService;

    @GetMapping("/{id}")
    public Result<Patient> getById(@PathVariable("id") Long id) {
        return Result.ok(patientService.getById(id));
    }

    @GetMapping
    public Result<List<Patient>> list() {
        return Result.ok(patientService.list());
    }

    @PostMapping
    public Result add(@RequestBody Patient patient) {
        return patientService.savePatient(patient) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Patient patient) {
        return patientService.updatePatient(patient) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return patientService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<Patient>> page(@PathVariable("currPage") Integer currPage,
                                            @PathVariable("pageSize") Integer pageSize,
                                            @RequestBody(required = false) SearchVO vo) {
        return Result.ok(patientService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return patientService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
