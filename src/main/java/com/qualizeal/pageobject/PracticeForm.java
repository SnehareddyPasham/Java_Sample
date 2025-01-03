package com.qualizeal.pageobject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qualizeal.utils.CommonWebUtils;

public class PracticeForm {
	public WebDriver driver;

	public PracticeForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	protected @FindBy(xpath = "//input[@placeholder = 'First Name']") 
	WebElement firstNameInput;
	protected @FindBy(xpath = "//input[@placeholder = 'Last Name']") 
	WebElement lastNameInput;
	protected @FindBy(xpath = "//input[@placeholder = 'name@example.com']") 
	WebElement emailInput;
	protected @FindBy(xpath = "//input[@placeholder = 'Mobile Number']") 
	WebElement mobileInput;
	protected @FindBy(xpath = "//input[@id = 'subjectsInput']") 
	WebElement subjectsField;
	protected @FindBy(xpath = "//input[@Id = 'dateOfBirthInput']") 
	WebElement dateOfBirthInput;
	protected @FindBy(xpath = "//textarea[@placeholder = 'Current Address']") 
	WebElement addressInput;
	protected @FindBy(xpath = "//input[@id = 'react-select-3-input']") 
	WebElement stateInput;
	protected @FindBy(xpath = "//input[@id ='react-select-4-input']") 
	WebElement cityInput;
	protected @FindBy(xpath = "//input[@id = 'uploadPicture']") 
	WebElement fileInput;
	protected @FindBy(xpath = "//button[@id = 'submit']") 
	WebElement submitButton;



	public WebElement getHobbyCheckbox(String hobby) {
		return driver.findElement(By.xpath("//label[text()='"+hobby+"']"));
	}
	public WebElement getGender(String gender) {
		return driver.findElement(By.xpath("//label[text()='" + gender + "']"));
	}

	public void fillFirstName(String firstName) {

		if (!firstName.equals("")) {
			Actions actions = new Actions(driver);
			actions.moveToElement(firstNameInput).perform();
			
			CommonWebUtils.scroll(firstNameInput, driver);
			CommonWebUtils.sendInput(firstNameInput, firstName);
			
		}

	}

	public void fillLastName(String lastName) {
		if (!lastName.equals("")) {
			CommonWebUtils.scroll(lastNameInput, driver);
			CommonWebUtils.sendInput(lastNameInput, lastName);
		}
	}

	public void fillEmail(String email) {
		
		CommonWebUtils.scroll(emailInput, driver);
		CommonWebUtils.sendInput(emailInput, email);

	}

	public void fillGender(String gender) {

		WebElement genderButton;
		
		if (!gender.equals("")) {
			genderButton =getGender(gender);
			CommonWebUtils.scroll(genderButton, driver);
			genderButton.click();
		}

	}

	public void fillMobileNumber(String mobileNumber) {

		if (!mobileNumber.equals("")) {
			CommonWebUtils.scroll(mobileInput, driver);
			CommonWebUtils.sendInput(mobileInput, mobileNumber);
		}
	}

	public void fillDateOfBirth(String DOB) {
		System.out.println(DOB);
		if (!DOB.equals("")) {
			CommonWebUtils.scroll(dateOfBirthInput, driver);
			CommonWebUtils.clickElement(dateOfBirthInput);
			String[] list = DOB.split("-");
			Map<String, String> monthMap = new HashMap<>();
			monthMap.put("Jan", "January");
			monthMap.put("Feb", "February");
			monthMap.put("Mar", "March");
			monthMap.put("Apr", "April");
			monthMap.put("May", "May");
			monthMap.put("Jun", "June");
			monthMap.put("Jul", "July");
			monthMap.put("Aug", "August");
			monthMap.put("Sep", "September");
			monthMap.put("Oct", "October");
			monthMap.put("Nov", "November");
			monthMap.put("Dec", "December");
			String day = list[0];
			int num = Integer.parseInt(day);
			String month = list[1];
			String fullMonth = monthMap.get(month);
			String year = list[2];
			System.out.println(day + "\t" + month + "\t" + year + "\t");
			WebElement yearField = driver.findElement(
					By.xpath("//select[@class = 'react-datepicker__year-select' ]//option[@value = '" + year + "']"));
			yearField.click();
			WebElement monthField = driver.findElement(By.xpath(
					"//select[@class = 'react-datepicker__month-select']//option[text() = '" + fullMonth + "']"));
			monthField.click();
			WebElement dayField = driver.findElement(By.xpath("//div[text() = '" + num + "']"));
			dayField.click();
		}

	}

	public void fillSubjects(String subjects) {

		CommonWebUtils.scroll(subjectsField, driver);
		String[] listOfSubjects = subjects.split(",");
		for (String i : listOfSubjects) {

			CommonWebUtils.sendInput(subjectsField, i);
			CommonWebUtils.sendInput(subjectsField, Keys.ENTER);

		}
	}

	public void fillHobbies(String hobbies) {
		if (!hobbies.equals("")) {
			WebElement checkBox;
			String[] listOFHobbies = hobbies.split(",");
			for (String hobby : listOFHobbies) {

				if (!hobby.equals("")) {

					checkBox = getHobbyCheckbox(hobby);
					Actions actions = new Actions(driver);
					actions.moveToElement(submitButton).click().perform();
					//CheckBoxUtils.selectCheckbox(checkBox);
				}

			}
		}
	}

	public void fillAddress(String address) {

		CommonWebUtils.scroll(addressInput, driver);
		CommonWebUtils.sendInput(addressInput, address);
	}

	public void fillState(String state) {

		CommonWebUtils.scroll(stateInput, driver);
		CommonWebUtils.sendInput(stateInput, state);
		stateInput.sendKeys(Keys.ENTER);
	}

	public void fillCity(String city) {

		if (cityInput.isEnabled()) {
			CommonWebUtils.scroll(cityInput, driver);
			CommonWebUtils.sendInput(cityInput, city);
			CommonWebUtils.sendInput(cityInput, Keys.ENTER);
		}

	}

	public void submitForm() {
		Actions actions = new Actions(driver);
		actions.moveToElement(submitButton).click().perform();

	}

	public void uploadFile(String picture) {
		String projectPath = System.getProperty("user.dir");
		// String filePath = Paths.get("src", "test", "resources", "InputFiles",
		// "Greetings").toAbsolutePath().toString();
		String filePath = projectPath + picture;
		System.out.println(filePath);
		fileInput.sendKeys(filePath);
		// CommonWebUtils.sendInput(fileInput,filePath);
	}

}
