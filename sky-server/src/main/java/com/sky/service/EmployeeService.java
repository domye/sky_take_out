package com.sky.service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import com.sky.dto.EmployeeDTO;

public interface EmployeeService {

    /**
     * 员工登录
     * 
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 员工注册
     * 
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 切换员工账号状态
     * 
     * @param id
     * @param status
     */
    void status(Integer status, Long id);

    /**
     * 根据id查询员工信息
     * 
     * @param id
     * @return
     */
    Employee getById(Long id);

    void edit(EmployeeDTO employeeDTO);
}
