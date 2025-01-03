package com.qualizeal.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonWebUtils {
	private static final Exception NullPointerException = null;

	public static void clickElement(WebElement element) {

		if (element.isDisplayed() & element.isEnabled()) {
			element.click();
		}

		else {
			System.out.println("Make sure that the element you are trying to click is visible and enabled ");
		}
	}

	public static void sendInput(WebElement element, String data) {

		if (element.isDisplayed() & element.isEnabled()) {

			element.clear();
			element.sendKeys(data);
		} else {
			System.out.println("Something is wrong");
		}

	}
	public static void sendInput(WebElement element, Keys key) {
		if (element.isDisplayed() & element.isEnabled()) {

			element.clear();
			element.sendKeys(key);
		} else {
			System.out.println("Something is wrong");
		}
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		if (text == null) {
			System.out.println("There is no visible text in the provided webelement");
			return null;
		} else
			return text;
	}

	public static String getAttributeValue(WebElement element, String Attribute) {

		String value = element.getAttribute(Attribute);
		if (value == null) {
			System.out.println("no such attribute" + " " + Attribute);
			return null;
		} else {
			return value;
		}

	}

	public static String getCssValue(WebElement element, String propertyName) {
		String value = element.getCssValue(propertyName);
		if (value == null) {
			System.out.println("no such css property");
			return null;
		} else {
			return value;
		}
	}

	public static String getTagname(WebElement element) throws Exception {
		if (element == null) {
			throw NullPointerException;
		} else {
			String tagName = element.getTagName();
			return tagName;
		}

	}

	public static Dimension getSize(WebElement element) {
		Dimension dimensions = element.getSize();
		return dimensions;

	}

	public static boolean getSize(int requiredWidth, int requiredHeight, int actualWidth, int actualHeight) {
		if (requiredWidth == actualWidth & requiredHeight == actualHeight)
			return true;
		return false;
	}

	public static Point getLocation(WebElement element) {
		Point p = element.getLocation();
		return p;
	}

	public static boolean getLocation(int requiredXcoordinate, int requiredYcoordinate, int actualXcoordinate,
			int actualYcoordinate) {
		if (requiredXcoordinate == actualXcoordinate & requiredYcoordinate == actualYcoordinate)
			return true;
		return false;
	}
	public static void scroll(WebElement element, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
