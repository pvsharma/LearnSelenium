package EXERCISE;

import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

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
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Vikram");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td[1]/div/a")));
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td[1]/div/a").click();

		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("The Title is matching with the expected");
		} else {
			System.out.println("The title is not matching with the expected");
		}

		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("CGI modified");
		driver.findElementByXPath("//input[@value='Update']").click();
		Thread.sleep(5000);

		String getCompanyName = driver.findElementById("viewLead_companyName_sp").getText();
		getCompanyName = getCompanyName.substring(0, getCompanyName.lastIndexOf("(")).trim();

		if (getCompanyName.equalsIgnoreCase("CGI modified")) {
			System.out.println("The modified company is displayed correctly " + getCompanyName);
		} else {
			System.out.println("The modified company name is not displayed " + getCompanyName);
		}

		// driver.close();

	}

}
