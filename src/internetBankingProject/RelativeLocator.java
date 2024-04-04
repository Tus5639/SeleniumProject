package internetBankingProject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.stream.events.EndDocument;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RelativeLocator {
	public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	driver.switchTo().newWindow(WindowType.TAB);
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> iter = handles.iterator();
	String parentWindow = iter.next();
	String childWindow = iter.next();
	driver.switchTo().window(childWindow);
	driver.get("https://rahulshettyacademy.com/learning-path");
	
	String name = driver.findElement(By.xpath("//h4/a")).getText();
	driver.switchTo().window(parentWindow);
	WebElement named= 	driver.findElement(By.name("name"));
	named.sendKeys(name);
	File newFile = 	named.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(newFile,new File(".\\screenshot\\name.png"));
	
//	File esteenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	try {
//	FileUtils.copyFile(esteenshot,new File("C:\\Users\\HP\\OneDrive\\Desktop\\internetBankingProject\\screenshot\\newpageg.png"));
//	}
//	catch(IOException e) {
//		System.out.println(e.getMessage());
//	}
	
	//get Hieght and Width
	System.out.println	(named.getRect().getDimension().getHeight()	);
	System.out.println(named.getRect().getDimension().getWidth());
	
	
	end(driver);
	
}
	
	@AfterTest
	public static void end(WebDriver driver) {
		driver.quit();
	}
}