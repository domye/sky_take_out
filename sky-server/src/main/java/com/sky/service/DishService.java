package com.sky.service;

import java.util.List;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

public interface DishService {

    /**
     * 增加菜品
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 分页查询菜品
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 删除菜品
     */
    void delete(List<Long> ids);

    /**
     * 根据id查询菜品
     */
    DishVO getById(Long id);

    /**
     * 根据分类id查询菜品
     * 
     * @param categoryId
     * @return
     */
    List<Dish> list(long categoryId);

    /**
     * 更新菜品状态
     * 
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);

    void updateDish(DishDTO dishDTO);

    List<DishVO> listWithFlavor(Dish dish);
}
