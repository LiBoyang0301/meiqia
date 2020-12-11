package org.lby.meiqia.system.controller;


import org.lby.meiqia.system.entity.Content;
import org.lby.meiqia.system.vo.SearchVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import org.lby.meiqia.system.service.ContentService;
import org.lby.meiqia.system.struct.PageResult;
import org.lby.meiqia.system.struct.Result;

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
@RequestMapping("/content")
public class ContentController {
    @Resource
	private ContentService contentService;

    @GetMapping("/{id}")
    public Result<Content> getById(@PathVariable("id") Long id) {
        return Result.ok(contentService.getById(id));
    }

    @GetMapping
    public Result<List<Content>> list() {
        return Result.ok(contentService.getList());
    }

    @PostMapping
    public Result add(@RequestBody Content content) {
        return contentService.saveContent(content) ? Result.ok() : Result.error();
    }

    @PutMapping
    public Result update(@RequestBody Content content) {
        return contentService.updateContent(content) ? Result.ok() : Result.error();
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Long id) {
        return contentService.delById(id) ? Result.ok() : Result.error();
    }

    @PostMapping("search/{currPage}/{pageSize}")
    public Result<PageResult<Content>> page(@PathVariable("currPage") Integer currPage,
                                            @PathVariable("pageSize") Integer pageSize,
                                            @RequestBody(required = false) SearchVO vo) {
        return Result.ok(contentService.page(currPage, pageSize, vo));
    }

    @PostMapping("delByIds")
    public Result delByIds(@RequestBody List<Long> ids) {
        return contentService.delByIds(ids) ? Result.ok() : Result.error();
    }

}
