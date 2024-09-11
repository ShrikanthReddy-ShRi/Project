package aug20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
@BeforeTest
public void generatereports()
{
	//define path of html
	reports = new ExtentReports("./ExetentReports/EReports.html");
}
@BeforeMethod
public void setUp()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://google.com/");
}
@Test
public void firstTestcase()
{
	logger = reports.startTest("Pass Test");
	logger.assignAuthor("ShRi");
	String Expected = "Google";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(Expected))
	{
		logger.log(LogStatus.PASS, "Titel is Matching :::"+Expected+"     "+Actual);
	}
	else
	{
		logger.log(LogStatus.FAIL, "Titel is Not Matching :::"+Expected+"     "+Actual);

	}
}
@Test
public void secondTestCase() throws Throwable
{
	logger = reports.startTest("Fail Test");
	logger.assignAuthor("ShRi");
	String Expected = "Facebook";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(Expected))
	{
		logger.log(LogStatus.PASS, "Titel is Matching :::"+Expected+"     "+ Actual);
	}
	else
	{
		logger.log(LogStatus.FAIL, "Titel is Not Matching :::"+Expected+"     "+ Actual);
	}
	
}
@AfterMethod
public void teardown()
{
	reports.endTest(logger);
	reports.flush();
	driver.quit();
}
}
