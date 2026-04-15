package com.caya.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	// Constructor 
	public BaseClass() {
		try {
			prop  =new Properties();
		    //path of the config.properties file 
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();  //study 
		}
	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
			 driver = new ChromeDriver(options);
			//driver=new ChromeDriver();
	}
//			else if(browserName.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver=new FirefoxDriver();
//		}else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
		
//		if (browserName == null) {
//	        throw new RuntimeException("Browser name not found in config.properties! Check the key name.");
//	    }
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	   driver.get(prop.getProperty("url"));
	   
	   
//	   prop.getProperty("username");
//	   prop.getProperty("password");
	   
	}

}
