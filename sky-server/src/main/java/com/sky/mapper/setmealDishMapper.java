package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.entity.SetmealDish;

@Mapper
public interface SetmealDishMapper {
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    void insertSetmealDishes(List<SetmealDish> setmealDishes);

    @Select("SELECT * FROM setmeal_dish WHERE setmeal_id = #{id}")
    List<SetmealDish> getSetmealDishesBySetmealId(Long id);
}
