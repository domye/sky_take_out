package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import com.sky.vo.SetmealVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐相关接口")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @PostMapping
    @ApiOperation(value = "新增套餐")
    public Result<String> saveSetMeal(@RequestBody SetmealDTO setmealdDto) {
        log.info("新增套餐：{}", setmealdDto);
        setmealService.save(setmealdDto);
        return Result.success();

    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询套餐")
    public Result<PageResult> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("套餐分页查询：{}", setmealPageQueryDTO);
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询套餐")
    public Result<SetmealVO> getSetmealById(@PathVariable("id") Long id) {
        log.info("根据id查询套餐:{}", id);
        SetmealVO setmealVO = setmealService.getSetmealById(id);
        return Result.success(setmealVO);
    }

    @DeleteMapping
    @ApiOperation(value = "删除套餐")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result<String> deleteSetmealByIds(@RequestParam List<Long> ids) {
        log.info("删除套餐：{}", ids);
        setmealService.deleteSetmealByIds(ids);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result<String> updateStatus(@PathVariable("status") Integer status, Long id) {
        setmealService.updateStatus(status, id);
        return Result.success();
    }

    @PutMapping
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.id")
    public Result<String> update(@RequestBody SetmealDTO setmealDTO) {
        setmealService.update(setmealDTO);
        return Result.success();
    }

}
