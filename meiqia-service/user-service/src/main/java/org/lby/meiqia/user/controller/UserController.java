package org.lby.meiqia.user.controller;


import org.lby.meiqia.common.annotation.WebLog;
import org.lby.meiqia.user.entity.User;
import org.lby.meiqia.user.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Resource
	private UserService userService;


    @WebLog
    @PostMapping("register")
    public Result register(String name, String pwd, Integer role){
        return userService.register(name,pwd,role)? Result.ok() : Result.error();
    }

    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable("id") Long id) {
        return Result.ok(userService.getDetails(id));
    }

    @GetMapping
    public Result<List<User>> list() {
        return Result.ok(userService.list());
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        return userService.saveUser(user) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        return userService.updateUser(user) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return userService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<User>> page(@PathVariable("currPage") Integer currPage,
                                         @PathVariable("pageSize") Integer pageSize,
                                         @RequestBody(required = false) SearchVO vo) {
        return Result.ok(userService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return userService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
