package DAY1;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableLessons {

	public static void main(String[] args) throws InterruptedException {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Vik");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
      // List<WebElement> count = driver.findElementsByXPath("//table[@class='x-grid3-row-table']");
  
       System.out.println(driver.findElements(By.xpath("//table[@class='x-grid3-row-table']")).size());
      // List<WebElement> count1 = driver.findElementsByClassName("x-grid3-row-table");
      // for (WebElement we : count) {
    	  
		
//System.out.println(we.getClass());
		
	//}
    //   System.out.println(countRows);
       

	
	
		
		
		
	
		
		

	}

}
