package com.sky.service;

import java.util.List;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

public interface SetmealService {

    void save(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    SetmealVO getSetmealById(Long id);

    void deleteSetmealByIds(List<Long> ids);

    void updateStatus(Integer status, Long id);

    void update(SetmealDTO setmealDTO);
}
