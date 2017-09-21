package DAY1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDroppable {

	public static void main(String[] args) {
		
		//STEP 1 Create driver instance ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		
		WebElement if1 = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(if1);
		
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElementById("draggable");
		WebElement target = driver.findElementById("droppable");
		
		act.dragAndDrop(source, target).build().perform();
	

		
		
		
		

	}

}
