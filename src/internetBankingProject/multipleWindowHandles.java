package internetBankingProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click')]")).click();
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> iter = handles.iterator();
		
		String parentWindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
		String child_message = driver.findElement(By.cssSelector("div h3")).getText();
		driver.switchTo().window(parentWindow);
		String parent_Message = driver.findElement(By.cssSelector("div h3")).getText();
		System.out.println(child_message);
		System.out.println(parent_Message);
		
		driver.quit();
		
		
	}

}
