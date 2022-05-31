package com.nbchand.exg.controller.Excel;

import com.nbchand.exg.pojo.EmployeePojo;
import com.nbchand.exg.pojo.Response;
import com.nbchand.exg.service.EmployeeService;
import com.nbchand.exg.util.ExcelHandler;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ExcelHandler excelHandler;

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody EmployeePojo employeePojo) {
        return ResponseEntity.ok(new Response("Employee created successfully!", employeeService.save(employeePojo)));
    }

    @GetMapping("/all")
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response("Employee list fetched successfully!", employeeService.findAll()));
    }

    @GetMapping("/excel")
    public ResponseEntity<Response> generateExcel() throws IOException, InvalidFormatException {
        excelHandler.writeDataLines(employeeService.findAll());
        return ResponseEntity.ok(new Response("Excel sheet of employees generated successfully!", null));
    }
}
