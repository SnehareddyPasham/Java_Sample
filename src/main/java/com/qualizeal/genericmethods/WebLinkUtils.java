package com.qualizeal.genericmethods;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class WebLinkUtils {
	public static void openLinkInNewTab(WebDriver driver, String hyperLink) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + hyperLink + "', '_blank');");
	}

	public static boolean isLinkWorking(String linkURL) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(linkURL).openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static void openLinkByJSExecutor(WebDriver driver) throws InterruptedException {
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='content']/ul/li/a"));
		// List<WebElement> links = driver.findElements(By.tagName("a"));

		int totalLinks = links.size();
		System.out.println("Total number of hyperlinks on the page: " + totalLinks);
		String hyperlink;
		JavascriptExecutor jsExecuter;
		for (int i = 0; i <= totalLinks; i++) {
			WebElement link = links.get(i);
			hyperlink = link.getAttribute("href");
			jsExecuter = (JavascriptExecutor) driver;
			jsExecuter.executeScript("window.open('" + hyperlink + "', '_blank');");
			Thread.sleep(2000);
		}
		driver.quit();
	}

	public static void openLinkByControClick(WebDriver driver) throws InterruptedException {
		String browser;
		DriverUtils.getDriver(driver, "https://the-internet.herokuapp.com");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.xpath("//*[@id='content']/ul/li/a"));
		System.out.println("Total number of hyperlinks on the page: " + links.size());

		// Iterate through links and open each in a new tab using Ctrl+Click
		for (WebElement link : links) {
			String hyperlink = link.getAttribute("href");

			if (isLinkWorking(hyperlink)) {

				System.out.println("Opening link: " + hyperlink);
				link.sendKeys(Keys.CONTROL, Keys.RETURN);
				Thread.sleep(2000);

			} else {
				System.out.println("Invalid hyperlink found: " + link.getText());
			}
		}

		driver.quit();

	}

	public static void openLinkByWindowHandling(WebDriver driver) throws InterruptedException {
		driver.manage().window().maximize();

		String mainWindow = driver.getWindowHandle();

		List<WebElement> links = driver.findElements(By.xpath("//*[@id='content']/ul/li/a"));
		System.out.println("Total number of hyperlinks on the page: " + links.size());

		for (WebElement link : links) {
			String hyperlink = link.getAttribute("href");

			if (isLinkWorking(hyperlink))

			{
				driver.switchTo().newWindow(WindowType.TAB);

				driver.get(hyperlink);

				Thread.sleep(2000);

				driver.switchTo().window(mainWindow);
			} else {
				System.out.println("Invalid hyperlink found: " + link.getText());
			}
		}

		driver.quit();
	}

}
