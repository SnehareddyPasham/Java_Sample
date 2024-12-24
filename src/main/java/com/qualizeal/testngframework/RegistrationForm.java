package com.qualizeal.testngframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationForm {
	static WebDriver driver = null;
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

	@BeforeTest
	public void browserInvoke() throws IOException {

		String browser = properties.getProperty("browser").toString();
		System.out.println("-------------" + browser + "---------");
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

	}

	@BeforeClass
	public void openApplication() throws InterruptedException {
		driver.get(properties.getProperty("url"));
		Thread.sleep(50000);

	}

	@DataProvider(name = "dp")
	public Object[][] readData() {
		ExcelDataHandler excelDataHandler = new ExcelDataHandler();
		// excelDataHandler.writeDataIntoExcel();
		return excelDataHandler.returnDataFromExcel();
		// return new Object[][] {{1,"02", "sneha", "hyderabad","455666666"}};
	}

	@Test(dataProvider = "dp")
	void testData(String sno, String employeeID, String employeeName, String Address, String mobileNum) {
		System.out.println(sno + "\t" + employeeID + "\t" + employeeName + "\t" + Address + "\t" + mobileNum);

	}

	public void fillFirstName(String firstName) {
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
		firstNameInput.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));
		lastNameInput.sendKeys();
	}

	public void fillEmail(String email) {
		WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder = 'name@example.com']"));
		emailInput.sendKeys(email);
	}

	public void fillGender(String gender) {
		if (gender == "Male") {
			WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value = 'Male']"));
			maleRadioButton.click();
		} else if (gender == "Female") {
			WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value = 'Female']"));
			femaleRadioButton.click();
		} else {
            WebElement otherButton = driver.findElement(By.xpath("//input[@value = 'Other']"));
            otherButton.click();
		}

	}
	public void fillMobileNumber(String mobileNumber) {
	     WebElement mobileInput = driver.findElement(By.xpath("//input[@placeholder = 'Mobile Number']"));
	     mobileInput.sendKeys(mobileNumber);
	}
	public void fillDateOfBirth(String day,  String month, String year) {
		WebElement DOBField = driver.findElement(By.xpath())
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
