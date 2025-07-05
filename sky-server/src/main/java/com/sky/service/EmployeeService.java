package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);



    /**
     * add a new employee
     *
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * query employee and Pagination
     * @param employeePageQueryDTO
     * @return
     */



    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * start or stop employee account
     * @param status
     * @param id
     */
    void stopOrStart(Integer status, Long id);

    /**
     * Query employee info by ID
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * update employee info
     * @param
     */

    void update(EmployeeDTO employeeDTO);
}
