package api.utilitie;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManger implements ITestListener 
{
	public ExtentSparkReporter sparkReporter;//LOOK AND FEELL OF THE REPORT 
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext testContext)
	{
	String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());//time stampe
//	repName ="Test-Report-"+timestamp+".html";
//	sparkReporter =new ExtentSparkReporter("C:\\Users\\admin\\eclipse-workspace\\PetStoreAutomation\\Reports"+ repName );
//	
	String reportPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + repName;
	sparkReporter = new ExtentSparkReporter(reportPath);

	sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
	sparkReporter.config().setReportName("pet store user API");
	sparkReporter.config().setTheme(Theme.DARK);
	
	
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Application", "pet store user API");
	extent.setSystemInfo("Enviornment", "QA");
			
	}
	
	public void onTestSucess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
		
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	public void onTestSkip(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skip");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
