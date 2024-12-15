package com.qualizeal.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualizeal.genericmethods.DriverUtils;
import com.qualizeal.genericmethods.CommonWebUtils;

public class DateTimePicker {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverUtils.openBrowser();
		DriverUtils.getDriver(driver, "https://www.spicejet.com/");

		WebElement dateTimeField = driver.findElement(By.xpath("//div[text() = 'Departure Date']"));
		CommonWebUtils.clickElement(dateTimeField);
		WebElement dateTime = driver.findElement(By.xpath("//div[text() = 'February ' and text()='2025']/../following-sibling::div[2]//div[text()='3']"));
		dateTime.click();
		// Enter the date and time directly
		// dateTimeField.sendKeys("2024-12-10T10:30"); // Example for ISO format
		Thread.sleep(3000);
		driver.quit();
	}

}
