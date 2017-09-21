package DAY1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsMouseOverClickAmazon {

	public static void main(String[] args) {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement source = driver.findElementByXPath("(//span[text()='Your Account'])[2]");
		WebElement dest = driver.findElementByXPath("//span[text()='Your Prime Membership']");
		
		
		
	act.moveToElement(source).click(dest).build().perform();
	


		
		
		
		

	}

}
