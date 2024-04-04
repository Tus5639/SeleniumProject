package internetBankingProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//java.util.Calendar cl = new Calendar();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		String handles = driver.getTitle();
		System.out.println(handles);
		String year ="2023";
		String month = "Nov";
		String Date = "18";
		//first date
		driver.findElement(By.id("first_date_picker")).click();
		//String tempmnth = driver.findElement(By.xpath("ui-datepicker-month")).getText();
		//String tempyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		while(!driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText().contains(year)){
  			driver.findElement(By.xpath("//div/a/span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		while(!driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText().contains(month)){
			driver.findElement(By.xpath("//div/a/span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		List<WebElement> datepick2 = driver.findElements(By.cssSelector("[data-handler=selectDay] a"));
		for(WebElement option:datepick2) {
			System.out.println(option.getText());
			String ele = option.getText();
			if(ele.contains(Date)) {
				option.click();
				break;
			}
		}
	Thread.sleep(5000);
		
//		driver.findElement(By.linkText(Date)).click();
//		Thread.sleep(5000);
//		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.close();
		}
	}

		//second list
//		driver.findElement(By.id("second_date_picker")).click();
//		//String tempmnth = driver.findElement(By.xpath("ui-datepicker-month")).getText();
//		//String tempyear = driver.findElement(By.className("ui-datepicker-year")).getText();
//		while(!driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText().contains(year)){
//			driver.findElement(By.xpath("//div/a/span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
//		}
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		while(!driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText().contains(month)){
//			driver.findElement(By.xpath("//div/a/span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
//		}
//		
//		List<WebElement> datepick2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"));
//		for(WebElement option:datepick2) {
//			if(option.getText().equalsIgnoreCase(Date)) {
//				option.click();
//				break;
//			}
//		}
//		//second_date_picker
	

