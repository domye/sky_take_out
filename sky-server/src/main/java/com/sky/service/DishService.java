package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {

    /**
     * 增加菜品
     */
    void saveWithFlavor(DishDTO dishDTO);
}
