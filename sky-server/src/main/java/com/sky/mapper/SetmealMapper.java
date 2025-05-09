package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * 
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    @Select("select * from setmeal where id = #{id}")
    SetmealVO getSetmealById(Long id);

    void deleteByIds(@Param("ids") List<Long> ids);

    void update(Setmeal setmeal);
}
