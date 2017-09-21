package DAY1;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.Test;

public class Login2 {

	@Test
	public  void login2() {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_32bit.exe");
		FirefoxDriver driver=new FirefoxDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		System.out.println(driver.findElementByTagName("h2").getText());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("CGI1");
		driver.findElementById("createLeadForm_firstName").sendKeys("Vikram");
		driver.findElementById("createLeadForm_lastName").sendKeys("Sharma");
		
		
		driver.findElementByClassName("smallSubmit").click();
		
		driver.quit();
		
		
		

	}

}
