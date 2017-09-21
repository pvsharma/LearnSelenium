package DAY1;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Login {

	@Test
	public  void login() throws IOException {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
/*		
		System.out.println(driver.findElementByTagName("h2").getText());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());*/
		driver.findElementById("createLeadForm_companyName").sendKeys("CGI1");
		driver.findElementById("createLeadForm_firstName").sendKeys("Vikram");
		driver.findElementById("createLeadForm_lastName").sendKeys("Sharma");
		
		WebElement drop1 = driver.findElementById("createLeadForm_marketingCampaignId");
		Select s1 = new Select(drop1);
		s1.selectByIndex(2);
		drop1 = driver.findElementById("createLeadForm_industryEnumId");
		s1 = new Select(drop1);
		s1.selectByVisibleText("Computer Software");
		
		File f1 = driver.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./snapsjot/s1.jpg");
		FileUtils.copyFile(f1, destFile);
		
		driver.findElementByClassName("smallSubmit").click();
		
		
		
		
		

	}

}
