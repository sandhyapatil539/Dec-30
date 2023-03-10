package com.durgasoft.ecommerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {

	private int retrycount = 0;
	private int maxretrycount = 3;

	public boolean retry(ITestResult arg0) {
		if (retrycount < maxretrycount) {
			log("Retrying test " + arg0.getName() + " with status " + getResultStatusName(arg0.getStatus())
					+ " for the " + (retrycount + 1) + " times");
			retrycount++;
			return true;
		}
		return false;
	}

	public void log(String string) {
		Reporter.log(string);
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAIL";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}
