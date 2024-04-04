package internetBankingProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class conditions {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[contains(@id,'Option2')]")).click();
		String constant = driver.findElement(By.xpath("//fieldset/label[@for=\"benz\"]")).getText();
		System.out.println(constant);
		Select drpdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		drpdown.selectByVisibleText(constant);
		driver.findElement(By.xpath("//fieldset/input[@id=\"name\"]")).sendKeys(constant);
		driver.findElement(By.xpath("//fieldset/input[@id=\"alertbtn\"]")).click();
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(constant)) {
			System.out.println("Test Validated");
		}
		else {
			System.out.println("Issue with the code");
		}
		driver.switchTo().alert().accept();
		driver.close();
	}
}
