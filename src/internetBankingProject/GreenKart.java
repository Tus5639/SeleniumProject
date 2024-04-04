package internetBankingProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GreenKart {
	public static void main(String[] args) throws InterruptedException {

		String[] Veggies = { "Cucumber", "Tomato", "Capsicum" };

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().fullscreen();
		
		// search box
		for (int i = 0; i < Veggies.length; i++) {
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Veggies[i]);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div[class='product'] div[class='product-action'] button")).click();

			driver.findElement(By.xpath("//input[@type='search']")).clear();
		}

		// Check Out
		driver.findElement(By.cssSelector("a[class='cart-icon'] img")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] div[class='action-block'] button")).click();

		Thread.sleep(2000);
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.className("promoBtn")).click();
		Thread.sleep(5000);
		String promocode = driver.findElement(By.className("promoInfo")).getText();
		Assert.assertEquals(promocode, "Code applied ..!");

		System.out.println(driver.findElement(By.xpath("//span[@class='discountAmt']")).getText());

		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(1000);
		Select drpdwn = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")));

		drpdwn.selectByVisibleText("India");

		driver.findElement(By.className("chkAgree")).click();
		Assert.assertTrue(driver.findElement(By.className("chkAgree")).isSelected());

		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		System.out.println("Thank you, your order has been placed successfully\r\n"
				+ "You'll be redirected to Home page shortly!!");
		driver.close();

	}

}
