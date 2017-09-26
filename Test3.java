package EXERCISE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3 {

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
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[@class='x-tab-strip-text ' and text()='Phone']").click();
		driver.findElementByName("phoneNumber").sendKeys("1234");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(8000);
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td[1]/div/a")));
		WebElement leadIdWe = driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[1]");
		String leadIdToDelete = leadIdWe.getText();
		leadIdWe.click();
		
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(leadIdToDelete);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(8000);
		
		
		if (driver.findElementByClassName("x-paging-info").getText().equalsIgnoreCase("No records to display"))
		{
			System.out.println("Correct error message is displayed");
		}
		else
		{
			System.out.println("Error message is not diaplyed");
		}
		

		
		 driver.close();

	}

}
