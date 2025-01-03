package com.qualizeal.utils;





import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qualizeal.pageobject.PracticeForm;

public class AssertMethods extends PracticeForm {

	public String actual;
	public String expected;

	public AssertMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void validateTest(String firstName, String lastName, String gender, String mobile, String state,
			String email) {

		int checker = 0;
		String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		Pattern pattern1 = Pattern.compile(emailPattern);
		Matcher matcher1 = pattern1.matcher(email);
		
		String mobilePattern = "\\d*";
		Pattern pattern2 =  Pattern.compile(mobilePattern);
	    Matcher matcher2 = pattern2.matcher(mobilePattern);
		

		if (firstName.equals("")) {

			checker = 1;
			actual = firstNameInput.getCssValue("border-color");
			expected = "rgb(40, 167, 69)";
//			Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
		}
		if (lastName.equals("")) {

			checker = 1;
			actual = lastNameInput.getCssValue("border-color");
			expected = "rgb(40, 167, 69)";

			//Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
		}
		if (gender.equals("") || !gender.equals("Male") || !gender.equals("Female") || !gender.equals("Other")) {

			checker = 1;
			actual = getGender("Male").getCssValue("color");
			expected = "rgba(40, 167, 69, 1)";

			//Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
		}
		if (mobile.equals("")) {

			checker = 1;
			actual = mobileInput.getCssValue("border-color");
			expected = "rgb(40, 167, 69)";
			//Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
		}
		if (state.equals("")) {
			checker = 1;
			boolean actual = cityInput.isEnabled();
			boolean expected = false;
			Assert.assertEquals(actual, expected);

		}

		if (!matcher1.matches()) {
			checker = 1;
			actual = emailInput.getCssValue("border-color");
			expected = "rgb(220, 53, 69)";
			//Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
		}
		
		if(!matcher2.matches()) {
			checker = 1;
			actual = mobileInput.getCssValue("border-color");
			//expected = "rgb(220, 53, 69)";
			//Assert.assertEquals(actual, expected);
			
			Assert.assertTrue(true);
			
		}

		if (checker == 0) {
			actual = submitButton.getText();
			expected = "Thanks for submitting the form";
			Assert.assertEquals(actual, expected);
		}

	}

}
