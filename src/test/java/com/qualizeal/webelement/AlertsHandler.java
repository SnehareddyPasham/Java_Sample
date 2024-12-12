package com.qualizeal.webelement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualizeal.genericmethods.CommonWebUtils;
import com.qualizeal.genericmethods.DriverUtils;

public class AlertsHandler {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver = DriverUtils.openBrowser();
		DriverUtils.getDriver(driver, "https://the-internet.herokuapp.com/javascript_alerts");
		//WebElement jsAlert = driver.findElement(By.xpath("//button[text() = \"Click for JS Alert\"]"));
		//WebElement jsAlert = driver.findElement(By.xpath("//button[text() = \"Click for JS Confirm\"]"));
		WebElement jsAlert = driver.findElement(By.xpath("//button[text() = \"Click for JS Prompt\"]"));
		CommonWebUtils.clickElement(jsAlert);
		Thread.sleep(3000);
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.sendKeys("proceed");
		//System.out.println("------");
		driver.switchTo().alert();
		Thread.sleep(3000);
		confirmAlert.accept();
		driver.close();
		
		
	}

}
