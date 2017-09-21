package DAY1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindows {

	public static void main(String[] args) {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("http://legacy.crystalcruises.com/");
		driver.manage().window().maximize();
		
		driver.findElementByPartialLinkText("GUEST CHECK-IN").click();
		
		Set<String> listOfWindows=driver.getWindowHandles();
		for (String w1 : listOfWindows) {
			driver.switchTo().window(w1);
		}
		
		driver.findElementByPartialLinkText("View Offer").click();
		
		 listOfWindows=driver.getWindowHandles();
		 System.out.println(listOfWindows.size());

driver.quit();
		
		
		

	}

}
