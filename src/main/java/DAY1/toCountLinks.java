package DAY1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class toCountLinks {

	public static void main(String[] args) {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		
		WebElement if1 = driver.findElementById("iframeResult");
		driver.switchTo().frame(if1);
		driver.findElementByXPath("/html/body/button").click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Vikram");
		alert1.accept();
		
		String checkName= driver.findElementById("demo").getText();
		
		if (checkName.contains("Vikram")){
			System.out.println("Name is correct");
		}
		else
		{
			System.out.println("Incorrect name");
		}
		
		
	

		
		
		
		

	}

}
