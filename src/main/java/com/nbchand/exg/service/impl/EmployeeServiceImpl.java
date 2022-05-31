package com.nbchand.exg.service.impl;

import com.google.gson.Gson;
import com.nbchand.exg.entity.Employee;
import com.nbchand.exg.pojo.EmployeePojo;
import com.nbchand.exg.repo.EmployeeRepo;
import com.nbchand.exg.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private Gson gson = new Gson();

    @Override
    public EmployeePojo save(EmployeePojo employeePojo) {
        Employee employee = gson.fromJson(gson.toJson(employeePojo),Employee.class);
        return new EmployeePojo(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeePojo> findAll() {
        return EmployeePojo.employeesToList(employeeRepo.findAll());
    }
}
