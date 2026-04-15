package com.caya.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue = { "com.caya.stepdefinations", "com.caya.hooks" },
		monochrome = false,   //console Readable use the monochrome
	    dryRun =false,
	    		plugin = {
	    		        "pretty",
	    		      //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    		        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	    		    }
	    				)   


public class TestRunner // extends AbstractTestNGCucumberTests 
{

}
