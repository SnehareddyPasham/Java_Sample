package com.qualizeal.webelement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualizeal.genericmethods.DriverUtils;

public class ImplicitWait {
	
	 public static void main(String[] args) throws InterruptedException{
	        WebDriver driver = DriverUtils.openBrowser();
	        Duration timeout = Duration.ofSeconds(10);
	        driver.manage().timeouts().implicitlyWait(timeout);
	        driver = DriverUtils.getDriver(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        Thread.sleep(3000);
	        WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
	        username.sendKeys("Admin");
	        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
	        password.sendKeys("admin123");
	        WebElement loginButton = driver.findElement(By.xpath("//button"));
	        loginButton.click();
	        Thread.sleep(2000);
	    
	        // No need to add explicit waits for elements
	        driver.quit();
	    }

}
