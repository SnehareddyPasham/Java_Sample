package com.qualizeal.webelement;

import java.util.HashMap;
import com.qualizeal.genericmethods.CommonWebUtils;
import com.qualizeal.genericmethods.DriverUtils;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenBrowser {
	public OpenBrowser() throws Exception {

		WebDriver driver = DriverUtils.openBrowser();

		Map<String, String[]> data = new HashMap<String, String[]>();
		data.put("github",
				new String[] { "https://github.com/login", "//*[@id='login_field']", "sushmaaluru5@gmail.com",
						"//*[@id='password']", "Aluru@14", "//*[@id='login']/div[4]/form/div/input[13]" });
		data.put("linkedin", new String[] { "https://www.linkedin.com/login", "//*[@id='username']", "snehareddy123",
				"//*[@id='password']", "2907", "//*[@id='organic-div']/form/div[4]/button" });

		for (Map.Entry<String, String[]> entry : data.entrySet()) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			DriverUtils.getDriver(driver, value[0]);
			WebElement usernameField = driver.findElement(By.xpath(value[1]));
			WebElement passwordField = driver.findElement(By.xpath(value[3]));
			WebElement loginButton = driver.findElement(By.xpath(value[5]));
			// usernameField.sendKeys(value[2]);
			CommonWebUtils.sendKeys(usernameField, value[2]);
			// passwordField.sendKeys(value[4]);
			CommonWebUtils.sendKeys(passwordField, value[4]);
			CommonWebUtils.clickElement(loginButton);
			System.out.println(key + "		   " + value[2] + "         " + value[4]);
			Thread.sleep(3000);

		}

		driver.quit();

	}

}
