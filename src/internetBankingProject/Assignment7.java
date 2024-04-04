package internetBankingProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testNG.Assignment;

public class Assignment7 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> ls = driver.findElements(By.cssSelector("table[name='courses'] tbody tr"));
		int noOfRows = ls.size();
		
		List<WebElement> ls_1 = driver.findElements(By.cssSelector("table[name='courses'] tbody tr th"));
		int noOfColumns = ls_1.size();
		
		String result = driver.findElement(By.cssSelector("table[name='courses'] tbody tr:nth-child(3)")).getText();
		
		System.out.println(noOfRows);
		System.out.println(noOfColumns);
		System.out.println(result);
		driver.close();
	}
}
