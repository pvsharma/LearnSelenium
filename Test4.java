package EXERCISE;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4 {

	public static String leadId = null;
	public static ChromeDriver driver;
	public static String expectedTitle = "View Lead | opentaps CRM";

	public static void login() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

	}

	public static void main(String[] args) throws InterruptedException {
		// STEP 1 Create driver instance ChromeDriver

		login();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//table[@name='ComboBox_partyIdFrom']/../a/img").click();
		String parent_window = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String w1 : allWindows) {
			if(!parent_window.equalsIgnoreCase(w1))
			{
			driver.switchTo().window(w1);

			driver.findElementByName("id").sendKeys("100");
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(8000);
			
			WebElement leadIdWe = driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[1]");
			leadIdWe.click();
			}
			
		}
		driver.switchTo().window(parent_window);
		
		driver.findElementByXPath("//table[@name='ComboBox_partyIdTo']/../a/img").click();
		allWindows = driver.getWindowHandles();
		for (String w1 : allWindows) {
			
			if(!parent_window.equalsIgnoreCase(w1))
			{
			driver.switchTo().window(w1);

			driver.findElementByXPath("//input[@name='id']").sendKeys("10");
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(8000);
			
			driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[1]").click();
			
		}
		}

		
		driver.switchTo().window(parent_window);
		
		driver.findElementByLinkText("Merge").click();
		
	Alert alt1 = driver.switchTo().alert();
	alt1.accept();
		// driver.close();

	}

}
