package internetBankingProject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart2 {
	public static void main(String[] args) throws InterruptedException {

		String[] Veggies = { "Cucumber", "Tomato", "Capsicum" };

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		List<WebElement> VegeTables = driver.findElements(By.cssSelector("h4.product-name"));
		int count = 0;

		for (int i = 0; i < VegeTables.size(); i++) {
			// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),\"ADD TO CART\")]")));
			Thread.sleep(5000);
			String[] newVeggie = VegeTables.get(i).getText().split("-");
			String formattedVeggie = newVeggie[0].trim();

			List itemToBeAdded = Arrays.asList(Veggies);

			if (itemToBeAdded.contains(formattedVeggie)) {
				count++;
				driver.findElements(By.xpath("//button[contains(text(),\"ADD TO CART\")]")).get(i).click();

				if (count == Veggies.length) {
					break;
				}
			}
		}
		// Check Out
		driver.findElement(By.cssSelector("a[class='cart-icon'] img")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] div[class='action-block'] button")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		String promocode = driver.findElement(By.className("promoInfo")).getText();
		Assert.assertEquals(promocode, "Code applied ..!");

		System.out.println(driver.findElement(By.xpath("//span[@class='discountAmt']")).getText());

		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='wrapperTwo']/div/select")));
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