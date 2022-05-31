package com.nbchand.exg.pojo;

import com.nbchand.exg.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {
    private Integer id;
    private String name;
    private String post;
    private Integer salary;

    public EmployeePojo(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.post = employee.getPost();
        this.salary = employee.getSalary();
    }

    public static List<EmployeePojo> employeesToList(List<Employee> employees) {
        return employees.stream().map(employee -> new EmployeePojo(employee)).collect(Collectors.toList());
    }
}
