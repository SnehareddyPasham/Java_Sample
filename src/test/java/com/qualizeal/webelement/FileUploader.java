package com.qualizeal.webelement;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualizeal.genericmethods.CommonWebUtils;
import com.qualizeal.genericmethods.DriverUtils;

public class FileUploader {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = DriverUtils.openBrowser();
		DriverUtils.getDriver(driver, "https://the-internet.herokuapp.com/upload");
		try {
			WebElement fileInput = driver.findElement(By.xpath("//input[@id = 'file-upload']"));

			
			Thread.sleep(3000);
			String projectPath = System.getProperty("user.dir");
			//String filePath = 	Paths.get("src", "test", "resources", "InputFiles", "Greetings").toAbsolutePath().toString();
            String filePath = projectPath + "\\src\\test\\resources\\InputFiles\\Greetings";
            System.out.println(filePath);
			fileInput.sendKeys(filePath);

			Thread.sleep(3000);
			
			WebElement submitButton = driver.findElement(By.xpath("//input[@id = 'file-submit']"));
			CommonWebUtils.clickElement(submitButton);
			Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			driver.close();
		}

	}

}
