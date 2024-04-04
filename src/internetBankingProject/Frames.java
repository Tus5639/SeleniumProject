package internetBankingProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames { 

	public static void main(String[] args) {
		// TODO Auto-generated method 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		System.out.println(driver.findElements(By.name("frame-top")).size());
		WebElement frame = driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(frame);
		//frame-middle
		WebElement framemid = driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(framemid);
		System.out.println(driver.findElement(By.id("content")).getText());
		

	}

}
