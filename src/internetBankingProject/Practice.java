package internetBankingProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		Thread.sleep(1000);
		WebElement drpdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdwn = new Select(drpdown);
		dropdwn.selectByVisibleText("USD");
		System.out.println(dropdwn.getFirstSelectedOption().getText());
		
		
		WebElement tet  = driver.findElement(By.id("divpaxinfo"));
		tet.click();
		System.out.println(tet.getText());
		int num = 0;
		Thread.sleep(1000);
		while(num<5) {
		driver.findElement(By.id("hrefIncAdt")).click();
		num++;
		}
		System.out.println(tet.getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		//
		
		//dynamic dropdown
		Thread.sleep(2000);
		 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		//a[@value='GOP']
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@value='GOP']")).click();
		//newdrp.click();
		//Select drpnew = new Select(newdrp);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		driver.findElement(By.id("autosuggest")).sendKeys("In");
		Thread.sleep(2000);
		
		List<WebElement> options =driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		int count = options.size();
		System.out.println(count);
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("Bahrain")) {
				option.click();
				break;
			}
		}
		//Select drpnext = new Select(nextdrp);
		//drpnext.selectByVisibleText("Bhopal (BHO)");
		//System.out.println(drpnext.getFirstSelectedOption().getText());
		
		driver.close();
		
	}
}
