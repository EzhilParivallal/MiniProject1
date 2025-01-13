package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {
	@BeforeSuite
	public void reportInitialization() {
		String path = "C:\\Users\\ezhil\\eclipse-workspace\\JAT_Project_1\\reports\\JATProject1Report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("MiniProject_1 Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	@Parameters({"url","browser"})
	@BeforeMethod

	public void launchAndLoadURL(String url,String browser) {
		// TODO Auto-generated method stub
		browserLaunch(url, browser);

	}
	@DataProvider(name ="excelRead")
	public String[][] excelRead() throws IOException {
		
		return readExcel(sheetName);
		
	}
	@AfterMethod
	public void browserClose() {
	   closeBrowser();	
	}
	@AfterSuite
	public void reportClose() {
		extent.flush();
	}


}
