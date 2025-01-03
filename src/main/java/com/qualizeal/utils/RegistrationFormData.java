package com.qualizeal.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class RegistrationFormData {
	@Test
	public Object[][] returnData() {
		// writeDataIntoExcel();
		try (FileInputStream fileIn = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//Data.xlsx")) {
			XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			int rows = sheet.getLastRowNum() + 1;
			System.out.println(rows);
			int cols = sheet.getRow(0).getLastCellNum();
			System.out.println(cols);
			Object[][] employeeData = new Object[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (sheet.getRow(i).getCell(j) == null)
						employeeData[i][j] = "";
					else
						employeeData[i][j] = sheet.getRow(i).getCell(j).toString();

				}

			}

			workbook.close();
			return employeeData;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Object[2][3];

	}

	public static void writeDataIntoExcel() {
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("User Data");

		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("FirstName");
		headerRow.createCell(1).setCellValue("LastName");
		headerRow.createCell(2).setCellValue("Email");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("Mobile");
		headerRow.createCell(5).setCellValue("Date Of Birth");
		headerRow.createCell(6).setCellValue("Subjects");
		headerRow.createCell(7).setCellValue("Hobbies");
		headerRow.createCell(8).setCellValue("Picture");
		headerRow.createCell(9).setCellValue("Current Address");
		headerRow.createCell(10).setCellValue("State");
		headerRow.createCell(11).setCellValue("City");
		Object[][] employeeData = { { "Snehalatha", "Pasham", "sneha@12345@gmail.com", "Female", "1234567809",
				"23 Dec 2024", "Maths,hindi", "Sports", " ", "Hyderabad", "Telangana", "Hyderabad" } };

		for (int i = 0; i < employeeData.length; i++) {
			Row row = sheet.createRow(i + 1);
			for (int j = 0; j < employeeData[i].length; j++) {
				row.createCell(j).setCellValue(employeeData[i][j].toString());
			}
		}

		try (FileOutputStream fileOut = new FileOutputStream(
				System.getProperty("user.dir") + "//src//test//resources//Data.xlsx")) {
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
