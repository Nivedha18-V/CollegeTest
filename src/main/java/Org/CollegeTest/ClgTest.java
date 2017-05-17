package Org.CollegeTest;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class ClgTest {
	public WebDriver driver;
	public String URL,Node;
	@Parameters("browser")
	@BeforeTest
	  public void test1(String browser) throws MalformedURLException
	  {
		  String URL="http://localhost:8090/JavaCl";

		  if(browser.equalsIgnoreCase("firefox"))
		  {
		  System.out.println("Executing on Firefox");
		  String Node="http://192.168.0.108:4458/wd/hub";
		  DesiredCapabilities cap=DesiredCapabilities.firefox();
		  cap.setBrowserName("firefox");
		  cap.setPlatform(Platform.WIN10);
		  driver=new RemoteWebDriver(new URL(Node),cap);
		  driver.manage().window().maximize();
		  driver.navigate().to(URL);
		  }

		  else if(browser.equalsIgnoreCase("chrome"))

		  {
		  System.out.println("Executing on Chrome");
		  System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_2.28.exe");
		  String Node="http://192.168.0.108:4458/wd/hub";
		  DesiredCapabilities cap=DesiredCapabilities.chrome();
		  cap.setBrowserName("chrome");
		  cap.setPlatform(Platform.WIN10);
		  driver=new RemoteWebDriver(new URL(Node),cap);
		  driver.manage().window().maximize();
		  driver.navigate().to(URL);
		  }  		 
	  }

  @Test
  public void test2() {
	  
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

	  driver.findElement(By.name("stname")).sendKeys("Nivedha");

	  driver.findElement(By.name("roll")).sendKeys("123");

	  driver.findElement(By.name("course")).sendKeys("MCA");

	  driver.findElement(By.name("fees")).sendKeys("30000");

	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  
	  driver.findElement(By.name("submit")).submit();
	 
	  String title=driver.getTitle();
	  if(title.equals("Student Detail Page"))
	  {
	  System.out.println("******Test Case Passed,Title Verified******");
	  System.out.println("You are Navigate to the Student Detail Page");
	  }
  }
  
  @AfterTest
  public void test3() {
  
  driver.quit();
  }
  
}
