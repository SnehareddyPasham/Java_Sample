package com.qualizeal.webelement;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import com.qualizeal.genericmethods.DriverUtils;
import com.qualizeal.genericmethods.WebLinkUtils;
import com.qualizeal.genericmethods.WebTableUtils;

public class Main {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverUtils.openBrowser();
		driver = DriverUtils.getDriver(driver, "https://the-internet.herokuapp.com");
		WebLinkUtils.openLinkByWindowHandling(driver);
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter no of rows");
//		int specificRow = scanner.nextInt();
//		System.out.println("Enter no of columns ");
//		int specificCol = scanner.nextInt();

//
//		//System.out.println("I am Here");
//
//		String colXPath = "//*[@id=\"table1\"]/tbody/tr[1]/td";
//		String rowXPath = "//*[@id=\"table1\"]/tbody/tr";
//		String webSiteUrl = "https://the-internet.herokuapp.com/tables";
//
//		driver = DriverUtils.get(driver, webSiteUrl);
//		int rowSize = WebTableUtils.getRowSize(driver, rowXPath);
//		int colSize = WebTableUtils.getColumnSize(driver, colXPath);
//
        int i = 1, j = 1;
		String headerXPath = "//*[@id=\'table1\']/thead/tr/th[" + i + "]/span[1]";
		String dataXPath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
		
		
//		if (specificRow > rowSize || specificCol > colSize) {
//			System.out.println("specifirow and specificcol must be less than or equals to rowSize and colSize");
//		} else {
//			WebTableUtils.printSpecificData(driver, rowSize, colSize, specificRow,
//					specificCol,headerXPath, dataXPath);
//		}

		
		// WebLinkUtils.openLinkByJSExecutor(driver);

		// WebLinkUtils.openLinkByControClick(driver);
	    

	}
}
