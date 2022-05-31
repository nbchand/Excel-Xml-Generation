package com.nbchand.exg.service;

import com.nbchand.exg.pojo.EmployeePojo;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
public interface EmployeeService {
    EmployeePojo save(EmployeePojo employeePojo);
    List<EmployeePojo> findAll();
}
