package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basepage.Basepage;

public class Listeners extends Basepage implements ITestListener {
	public  WebDriver driver;
	public void onTestStart(ITestResult arg0) { 
    Reporter.log("Test start running:"+ arg0.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult arg0) {
    Reporter.log ("Test is skipped:" + arg0.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult arg0) { 
    Reporter.log(" Test is sucess:"+ arg0.getMethod().getMethodName());
	Calendar cal=Calendar.getInstance();
	SimpleDateFormat simpledate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_");
	String methodName=arg0.getName();
	if(arg0.isSuccess()) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String reportDirectory=(new File(System.getProperty("user dir")).getAbsolutePath()
    		     +"/src/main/com/java/durgasoft/ecommerce");
		
		File target= new File((String)reportDirectory+"/passedscreens/" +methodName+"_"
                  +simpledate.format(cal.getTime()) + ".png");

		try {
		FileUtils.copyFile(src, target);
        }catch (IOException e) {
        // TODO Auto-generated catch  block
        e.printStackTrace();
	}
	}
	}
     public void onTestFailure(ITestResult arg0) {
   
     Reporter.log(" Test is failed:"+ arg0.getMethod().getMethodName());
 	Calendar cal=Calendar.getInstance();
 	SimpleDateFormat simpledate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_");
 	String methodName=arg0.getName();
 	if(arg0.isSuccess()) {
 		
 		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         String reportDirectory=(new File(System.getProperty("user.dir")).getAbsolutePath()
     		     +"/src/main/com/java/durgasoft/ecommerce");
 		
 		File target= new File((String)reportDirectory+"/failedscreens/" +methodName+"_"
                   +simpledate.format(cal.getTime()) + ".png");

 		try {
 		FileUtils.copyFile(src, target);
         }catch (IOException e) {
         // TODO Auto-generated catch  block
         e.printStackTrace();
 	}
 	}
 	}
}

	



