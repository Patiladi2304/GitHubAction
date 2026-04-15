package com.caya.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import com.caya.base.BaseClass;
import com.caya.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {
	LoginPage loginPage;
	//private static final Logger logger = LogManager.getLogger(Hooks.class);
	private static final  Logger log = LogManager.getLogger(LoginSteps.class);
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    loginPage= new LoginPage();
	    log.info("Login Page");
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
	    log.info("Enter Username and Password");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   loginPage.clickLogin();
	    log.info("Click Login Button ");
	}

	@Then("user should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() {
		String actualTitle = driver.getTitle();
		System.out.println("Page Title : "+ actualTitle);
        Assert.assertEquals("Cayya| Login", actualTitle);
	    log.info("Page title Compare");
	}
	

}
