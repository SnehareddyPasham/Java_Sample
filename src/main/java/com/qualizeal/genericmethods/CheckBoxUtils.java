package com.qualizeal.genericmethods;

import org.openqa.selenium.WebElement;

public class CheckBoxUtils {
	public static boolean isCheckboxSelected(WebElement element) {
		if(!element.isSelected()) return false;
		return true;
	}

}
