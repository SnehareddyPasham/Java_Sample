package com.qualizeal.webelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qualizeal.genericmethods.DriverUtils;

public class ExplicitWait {
	public static void main(String args[]) {
		WebDriver driver = DriverUtils.openBrowser();
		DriverUtils.getDriver(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		//WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'username']")));
		username.sendKeys("Admin");
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'password']")));
		password.sendKeys("admin123");
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
		loginButton.click();
		driver.close();
	}

}
