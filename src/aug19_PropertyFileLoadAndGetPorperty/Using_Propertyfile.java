package aug19_PropertyFileLoadAndGetPorperty;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Using_Propertyfile {
 WebDriver driver;
 Properties pro;
 @BeforeMethod 
 public void setUp() throws Throwable
 {
	 pro = new Properties();
	 // load Property file
	 pro.load(new FileInputStream("Primus.properties"));
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(pro.getProperty("Url"));
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.findElement(By.xpath(pro.getProperty("Objuser"))).sendKeys(pro.getProperty("Username"));
	 driver.findElement(By.xpath(pro.getProperty("Objpwd"))).sendKeys(pro.getProperty("Password"));
	 driver.findElement(By.xpath(pro.getProperty("objlogin"))).click();
}
 @Test
 public void branch_creation() throws Throwable
 {
	 driver.findElement(By.xpath(pro.getProperty("ObjBranches"))).click();
	 driver.findElement(By.xpath(pro.getProperty("ObjNewbranch"))).click();
	 driver.findElement(By.xpath(pro.getProperty("ObjBname"))).sendKeys(pro.getProperty("Branch"));
	 driver.findElement(By.xpath(pro.getProperty("ObjAdd1"))).sendKeys(pro.getProperty("Add1"));
	 driver.findElement(By.xpath(pro.getProperty("ObjAdd2"))).sendKeys(pro.getProperty("Add2"));
	 driver.findElement(By.xpath(pro.getProperty("ObjAdd3"))).sendKeys(pro.getProperty("Add3"));
	 driver.findElement(By.xpath(pro.getProperty("ObjArea"))).sendKeys(pro.getProperty("Area"));
	 driver.findElement(By.xpath(pro.getProperty("ObjZip"))).sendKeys(pro.getProperty("Zip"));
	 new Select(driver.findElement(By.xpath(pro.getProperty("ObjCountry")))).selectByVisibleText(pro.getProperty("Country"));
	 Thread.sleep(2000);
	 new Select(driver.findElement(By.xpath(pro.getProperty("ObjState")))).selectByVisibleText(pro.getProperty("State"));
	 Thread.sleep(2000);
	 new Select(driver.findElement(By.xpath(pro.getProperty("ObjCity")))).selectByVisibleText(pro.getProperty("City"));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath(pro.getProperty("ObjBsubmit"))).click();
	 String alerttext = driver.switchTo().alert().getText();
	 System.out.println(alerttext);
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
 }
 @Test
 public void role_creation() throws Throwable
 {
	 driver.findElement(By.xpath(pro.getProperty("ObjRoles"))).click();
	 driver.findElement(By.xpath(pro.getProperty("ObjNewrole"))).click();
	 driver.findElement(By.xpath(pro.getProperty("ObjRname"))).sendKeys(pro.getProperty("Role"));
	 driver.findElement(By.xpath(pro.getProperty("ObjRdes"))).sendKeys(pro.getProperty("Roledes"));
	 new Select(driver.findElement(By.xpath(pro.getProperty("ObjRtype")))).selectByVisibleText(pro.getProperty("Roletype"));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath(pro.getProperty("ObjRsubmit"))).click();
	 String alrttxt = driver.switchTo().alert().getText();
	 System.out.println(alrttxt);
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
 }
 @AfterMethod
 public void tearDown()
 {
	 driver.findElement(By.xpath(pro.getProperty("ObjLogout"))).click();
	 driver.quit();
 }
}
