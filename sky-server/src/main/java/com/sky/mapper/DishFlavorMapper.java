package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sky.entity.DishFlavor;

@Mapper
public interface DishFlavorMapper {

    void insertBatch(List<DishFlavor> dishFlavors);

    void deleteByDishIds(List<Long> ids);
}
