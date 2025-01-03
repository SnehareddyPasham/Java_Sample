package com.qualizeal.basesetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qualizeal.genericmethods.DriverUtils;

public class BaseClass {
	protected static WebDriver driver = null;
	Properties properties = new Properties();
	@BeforeSuite
	public void gotoDirectory() throws IOException {

		String rootDirectory = System.getProperty("user.dir");
		String projectPath = "//src//test//resources//browser.properties";
		String path = rootDirectory + projectPath;
		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		} catch (FileNotFoundException f) {
			f.printStackTrace();

		}
	}

	@BeforeMethod
	public void openApplication() throws InterruptedException {
		String browser = properties.getProperty("browser").toString();
		System.out.println("-------------" + browser + "---------");
		driver = DriverUtils.openBrowser(browser);
		driver.get(properties.getProperty("url"));

	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
