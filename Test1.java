package EXERCISE;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {

	public static String leadId=null;
	
	
	public static void main(String[] args) throws InterruptedException {
		//STEP 1 Create driver instance ChromeDriver
		
		
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		
		WebElement drop1 = driver.findElementById("createLeadForm_marketingCampaignId");
		Select s1 = new Select(drop1);
		s1.selectByIndex(2);
		drop1 = driver.findElementById("createLeadForm_dataSourceId");
		s1 = new Select(drop1);
		s1.selectByVisibleText("Cold Call");
		
		
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("123456789");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("abc@abc.com");
		driver.findElementByClassName("smallSubmit").click();
		
		String getId=driver.findElementById("viewLead_companyName_sp").getText();
		
		leadId = getId.substring(getId.lastIndexOf("(")+1, getId.length()-1);
		
		System.out.println("The leadId is " + leadId);
		Thread.sleep(5000);
		driver.findElementByLinkText("Find Leads").click();
	
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(10000);
		driver.findElementByLinkText("10423").click();;
		driver.findElementByLinkText("Edit").click();
		//driver.quit();	// TODO Auto-generated method stub

	}

}


