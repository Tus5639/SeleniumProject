package internetBankingProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		String products = "mobile phones";
		String url ="https://www.amazon.in";
		
		WebDriver  driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(products);
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> Amazon_products = driver.findElements(By.cssSelector("h2"));
		for(WebElement option:Amazon_products) {
			if(option.getText().equalsIgnoreCase("Motorola G34 5G (Ice Blue, 8GB RAM, 128GB Storage)")) {
				option.click();
				System.out.println(option.getText());
				break;
			}
			
		}
		Set<String> window_handles = driver.getWindowHandles();
		Iterator<String> iter = window_handles.iterator();
		
		String  parent_window = iter.next();
		String child_Window = iter.next();
		
		driver.switchTo().window(child_Window);
		WebElement image = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
		Actions action = new Actions(driver);
		action.moveToElement(image).perform();
		
		String product_Value = driver.findElement(By.xpath("//div[@id='corePrice_feature_div']/div/div/span/span")).getText();
		System.out.println(product_Value);
		Assert.assertEquals(product_Value, "₹12,948");
		
		driver.quit();
	}
}
