package com.qualizeal.genericmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTableUtils {

	public static int getRowSize(WebDriver driver, String rowXPath) {
		int rowSize = driver.findElements(By.xpath(rowXPath)).size();
		return rowSize;
	}

	public static int getColumnSize(WebDriver driver, String colXPath) {
		int colSize = driver.findElements(By.xpath(colXPath)).size();
		return colSize;

	}

	public void printTableData(WebDriver driver, int rowSize, int colSize,  String headerXPath, String dataXPath) {

		String data = "";
		

		for (int i = 1; i < colSize; i++) {
			// data = driver.findElement(By.xpath("//*[@id=\'table1\']/thead/tr/th[" + i +
			// "]/span[1]")).getText();
			data = driver.findElement(By.xpath(headerXPath)).getText();
			System.out.print(String.format("%-25s", data));

		}
		System.out.println();

		for (int i = 1; i <= rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {
				// data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i +
				// "]/td[" + j + "]")).getText();
				data = driver.findElement(By.xpath(dataXPath)).getText();

				System.out.print(String.format("%-25s", data));
			}
			System.out.println();
		}

	}

	public static String[][] returnTableData(WebDriver driver, int rowSize, int colSize, String headerXPath, String dataXPath) {
		String data = "";

		String[][] tableData = new String[rowSize + 1][colSize];

		for (int i = 1; i <= colSize; i++) {
			//data = driver.findElement(By.xpath("//*[@id=\'table1\']/thead/tr/th[" + i + "]/span[1]")).getText();
			data = driver.findElement(By.xpath(headerXPath)).getText();

			tableData[0][i - 1] = data;
			// System.out.println(tableData[0][i-1]);

		}

		for (int i = 1; i <= rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {
				//data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				data = driver.findElement(By.xpath(dataXPath)).getText();

				tableData[i][j - 1] = data;
				// System.out.println(tableData[i][j-1]);
			}

		}
		return tableData;
	}
	public static void getXPath() {
		
	}

	public static void printSpecificData(WebDriver driver, int rowSize, int colSize, int specificRow, int specificCol ) {

		String data;

		for (int i = 1; i < colSize; i++) {
			data = driver.findElement(By.xpath("//*[@id=\'table1\']/thead/tr/th[" + i + "]/span[1]")).getText();
			System.out.print(String.format("%-25s", data));

		}
		System.out.println();

		for (int i = specificRow; i <= rowSize; i++) {
			for (int j = specificCol; j <= colSize; j++) {
				data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				System.out.print(String.format("%-25s", data));
			}
			System.out.println();
		}

	}

}