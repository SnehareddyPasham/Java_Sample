package com.qualizeal.genericmethods;

import org.openqa.selenium.WebDriver;
import java.util.Scanner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {

	public static WebDriver openBrowser() {
		String browser;
		WebDriver driver = null;
		System.out.print("enter the browser(Chrome / Firefox / Microsoft Edge): ");
		Scanner scanner = new Scanner(System.in);
		browser = scanner.next();
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Enter a valid browser.");
			break;
		}
		driver.manage().window().maximize();
		scanner.close();
		return driver;
	}

	public static WebDriver getDriver(WebDriver driver, String url) {
		driver.get(url);
		return driver;

	}

}
