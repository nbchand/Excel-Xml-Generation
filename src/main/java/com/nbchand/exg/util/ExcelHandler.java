package com.nbchand.exg.util;

import com.nbchand.exg.pojo.EmployeePojo;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Component
@RequiredArgsConstructor
public class ExcelHandler {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void writeHeader(String sheetName) throws IOException, InvalidFormatException {
//        File file = new File("src\\main\\resources\\employees.xls");
//        if (!file.exists()) {
//            file.createNewFile();
//        }

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);

        createCell(row, 0, "S.N");
        createCell(row, 1, "ID");
        createCell(row, 2, "Name");
        createCell(row, 3, "Post");
        createCell(row, 4, "Salary");
    }

    public void createCell(Row row, int columnCount, Object value) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
    }

    public void writeDataLines(List<EmployeePojo> employeePojoList) throws IOException, InvalidFormatException {
        writeHeader("Employees");
        int rowCount = 1, sn = 1;
        for (EmployeePojo employeePojo : employeePojoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, sn);
            createCell(row, columnCount++, employeePojo.getId());
            createCell(row, columnCount++, employeePojo.getName());
            createCell(row, columnCount++, employeePojo.getPost());
            createCell(row, columnCount++, employeePojo.getSalary());
            sn++;
        }
        //create file
        String desktop = System.getProperty("user.home") + File.separator + "Desktop";
        File file = new File(desktop + "\\employees.xls");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
    }
}
