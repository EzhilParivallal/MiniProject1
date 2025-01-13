package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethods;

public class ListenerClass extends ProjectSpecificationMethods implements ITestListener{
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filepath=null;
		try {
			filepath= screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
	}


}
