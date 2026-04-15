package com.caya.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.caya.base.BaseClass;

public class LoginPage extends BaseClass {

	// WebElement
	
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password-field")
	WebElement pwdField;

	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signinButton;

	// Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void enterUsername(String user) {
		emailField.sendKeys(user);
		
	}
	

	public void enterPassword(String pwd) {
		pwdField.sendKeys(pwd);
	}

	public void clickLogin() {
		signinButton.click();
	}

}
