package internetBankingProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multipleWindowHandles2 {
	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("Tushar");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.xpath("//label[2]/span[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select drpdwn = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		drpdwn.selectByIndex(1);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String usernmae = driver.findElement(By.xpath("//div/p/b[1]/i[1]")).getText();
		String password = driver.findElement(By.xpath("//div/p/b[2]/i")).getText();
		driver.findElement(By.xpath("//body/a")).click();
		//System.out.println(password);
		//driver.switchTo().frame(password);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/a[1]")));
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		
		String parentW = iter.next();
		String childW = iter.next();
		
		driver.switchTo().window(childW);
		//driver.findElement(By.cssSelector("div a")).click();
		driver.switchTo().window(parentW);
		driver.navigate().refresh();
		//again enter correct values
		driver.findElement(By.id("username")).sendKeys(usernmae);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//label[2]/span[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select drpdwn1 = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		drpdwn1.selectByIndex(1);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		driver.quit();
		
	}
}
