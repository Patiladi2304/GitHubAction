package com.caya.hooks;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.caya.base.BaseClass;
import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void setup() {
		// Calls the initialization method from BaseClass to launch the browser
		initialization();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
		TakesScreenshot t	=(TakesScreenshot) driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File path =new File("./Screenshot/image_" + timestamp + ".png");
		Files.copy(src,path);
		}

		if (driver != null) {
			driver.quit();
		}

	}

}
