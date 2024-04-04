package internetBankingProject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		// implicitWait defined for page to Load
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ExplicitWait intialisation
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		// Input Value on Login page
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("learning");

		driver.findElement(By.xpath("//label[2]//span[2]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/button[2]")));
		driver.findElement(By.xpath("//div[2]/button[2]")).click();

		Select drp = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		drp.selectByVisibleText("Consultant");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]/a[1]")));
		System.out.println(driver.getCurrentUrl());

		List<WebElement> cartbutton = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		// cartbutton.size();
		for (int i = 0; i < cartbutton.size(); i++) {
			cartbutton.get(i).click();

		}

		driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Ind");
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='suggestions']/ul")));
		List<WebElement> country = driver.findElements(By.xpath("//div[@class='suggestions']/ul"));
		int count = country.size();
		for (WebElement option : country) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.xpath("//div/label/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div/button[@class='btn btn-info']"))));
		driver.findElement(By.xpath("//div/button[@class='btn btn-info']")).click();

		driver.findElement(By.xpath(("//input[@value='Purchase']"))).click();

		System.out.println(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

		driver.quit();
	}

}
