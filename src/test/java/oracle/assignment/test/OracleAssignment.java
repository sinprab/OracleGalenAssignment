package oracle.assignment.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import oracle.assignment.utilities.GalenManager;
import oracle.assignmnet.driverFactory.DriverManager;
import oracle.assignmnet.utilities.PropertyReader;

public class OracleAssignment extends DriverManager {
	
	ExtentReports reports;
	ExtentTest test;
	@BeforeSuite
	public void setUpReporting()
	{
		reports = new ExtentReports("target/extentReports.html", true);
	}
	
	@BeforeTest
    public void setUp()
    {
		try
		{
		DriverManager.setDriver();
        driver.get(PropertyReader.getProperty("testUrl"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
	@Test
	public void verifyHeaderLayout()
	{
		try
		{
		String gspecFilePath = "gspec/homePage.gspec";
		test = reports.startTest("Verify Header Layout");
		GalenManager.checkAndReportLayout(gspecFilePath, "header",test);
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='form-control']"));
		if(searchBox.getAttribute("placeholder").equals("Search"))
				{
					test.log(LogStatus.PASS, "<B style=\"color:blue\">Search Place Holder is Present</B><br> ");
				}
		else
			{
				test.log(LogStatus.FAIL, "<B style=\"color:red\">Search Place Holder is not Present</B><br> ");
			}
		reports.endTest(test);

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyFooterLayout()
	{
		try
		{
		String gspecFilePath = "gspec/homePage.gspec";
		test = reports.startTest("Verify Footer Layout");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)");
		GalenManager.checkAndReportLayout(gspecFilePath, "footer",test);
		reports.endTest(test);

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	@AfterTest
    public void tearDown()
    {
        driver.quit();

    }
	
	@AfterSuite
	public void closeReport()
	{
		reports.close();
	}
}
