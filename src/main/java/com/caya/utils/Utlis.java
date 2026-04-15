package com.caya.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.caya.base.BaseClass;

public class Utlis extends BaseClass{
	
	// Common Explicit Wait method
    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Custom Click using JavaScript (useful when normal click fails)
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    // Scroll to an element
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    // Switch to Frame by index
    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }
    
    //close driver 
    public static void quitDriver() {
        driver.quit();
    }

}
