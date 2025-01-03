package com.qualizeal.maintest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualizeal.basesetup.BaseClass;
import com.qualizeal.pageobject.PracticeForm;
import com.qualizeal.utils.RegistrationFormData;
import com.qualizeal.utils.AssertMethods;

public class MainClass extends BaseClass {

	@DataProvider(name = "studentData")
	public Object[][] readData() {
		RegistrationFormData excelDataHandler = new RegistrationFormData();
		return excelDataHandler.returnData();

	}

	@Test(dataProvider = "studentData")
	public void fillForm(String firstName, String lastName, String email, String gender, String mobile, String DOB,
			String subjects, String hobbies, String picture, String address, String state, String city)
			throws InterruptedException {

		PracticeForm practiceForm = new PracticeForm(driver);
		practiceForm.fillFirstName(firstName);
		practiceForm.fillLastName(lastName);
		practiceForm.fillEmail(email);
		practiceForm.fillGender(gender);
		practiceForm.fillMobileNumber(mobile);
		practiceForm.fillDateOfBirth(DOB);
		Thread.sleep(2000);
		practiceForm.fillSubjects(subjects);
		practiceForm.fillHobbies(hobbies);
		practiceForm.fillAddress(address);
		practiceForm.fillState(state);
		practiceForm.fillCity(city);
		practiceForm.uploadFile(picture);
		Thread.sleep(5000);
		practiceForm.submitForm();
		Thread.sleep(2000);
		AssertMethods assertMethods = new AssertMethods(driver);
		assertMethods.validateTest(firstName, lastName, gender, mobile, state, email);

	}

}
