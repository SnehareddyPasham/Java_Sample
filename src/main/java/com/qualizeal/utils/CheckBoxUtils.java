package com.qualizeal.utils;

import org.openqa.selenium.WebElement;

public class CheckBoxUtils {
	public static void selectCheckbox(WebElement element) {
		if(!element.isSelected()) 
		{
			element.click();
		}
	}
	

}
