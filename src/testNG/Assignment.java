package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment {
	
	@Test
	public static void Nation() throws InterruptedException {
	//WebDriver driver = null;
	//public static void main(String[] args) throws InterruptedException {
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/angularpractice/");
		driver1.findElement(By.name("name")).sendKeys("Tushar Chaudhary");
		driver1.findElement(By.name("email")).sendKeys("tushar@gmail.com");
		driver1.findElement(By.id("exampleInputPassword1")).sendKeys("123456789");
		driver1.findElement(By.id("exampleCheck1")).click();
		WebElement dropdwn = driver1.findElement(By.id("exampleFormControlSelect1"));
		Select drp = new Select(dropdwn);
		drp.selectByIndex(1);

		driver1.findElement(By.id("inlineRadio1")).click();
		driver1.findElement(By.name("bday")).sendKeys("01/14/2024");
		driver1.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		System.out.println(
				driver1.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		driver1.close();
	}

}
