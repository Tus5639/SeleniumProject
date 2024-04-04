package internetBankingProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment_8  {
	@Test
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("fieldset input[id='autocomplete']")).sendKeys("uni");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.cssSelector("fieldset input[id='autocomplete']")).sendKeys(Keys.DOWN);
		
		driver.findElement(By.cssSelector("fieldset input[id='autocomplete']")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.cssSelector("fieldset input[id='autocomplete']")).getAttribute("value"));	
	}
}
