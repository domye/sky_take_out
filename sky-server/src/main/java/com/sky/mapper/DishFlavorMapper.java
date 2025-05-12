package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.entity.DishFlavor;

@Mapper
public interface DishFlavorMapper {

    void insertBatch(List<DishFlavor> dishFlavors);

    void deleteByDishIds(List<Long> ids);

    /**
     * 根据菜品id查询对应的口味数据
     * 
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
