package com.qualizeal.testngframework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataHandler {
	@Test
	public Object[][] returnDataFromExcel() {
		
		try (FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//employee_data.xlsx")) {
			XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
			XSSFSheet sheet = workbook.getSheet("Employee Data");
			int rows = sheet.getLastRowNum()+1;
			int cols = sheet.getRow(0).getLastCellNum();
			Object [][] employeeData = new Object[rows][cols];
			for (int i = 0;i< rows;i++) {
				for (int j = 0;j< cols;j++) {
					
					employeeData[i][j] = sheet.getRow(i).getCell(j).toString();
					//System.out.print(employeeData[i][j] + "\t");
					
				}
				//System.out.println();
				
			}
			workbook.close();
			return employeeData;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Object[3][4];
		
	}

	public static void writeDataIntoExcel() {
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Employee Data");

		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(1).setCellValue("Employee ID");
		headerRow.createCell(2).setCellValue("Employee Name");
		headerRow.createCell(3).setCellValue("Address");
		headerRow.createCell(4).setCellValue("Ph.No");

		Object[][] employeeData = { { 1, "Emp_01", "Employee1", "Hyderabad", "999999" },
				{ 2, "Emp_02", "Employee2", "Bangalore", "888888" }, { 3, "Emp_03", "Employee3", "vizag", "666666" } };

		for (int i = 0; i < employeeData.length; i++) {
			Row row = sheet.createRow(i + 1);
			for (int j = 0; j < employeeData[i].length; j++) {
				row.createCell(j).setCellValue(employeeData[i][j].toString());
			}
		}

		try (FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//employee_data.xlsx")) {
			workbook.write(fileOut);
			System.out.println("Excel file written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
