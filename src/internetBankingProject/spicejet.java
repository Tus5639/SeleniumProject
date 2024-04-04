package internetBankingProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class spicejet {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// autosuggestion dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Br");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]/li"));
		int count = options.size();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("British Indian Ocean Territory")) {
				option.click();
				break;
			}
		}

		// radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='ATQ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='ctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='GOP']"))
				.click();

		// date
		// driver.findElement(By.name("ctl00$mainContent$view_date1")).sendKeys("15/01");
		// driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// passenger addition
		WebElement tet = driver.findElement(By.id("divpaxinfo"));
		tet.click();
		System.out.println(tet.getText());
		int num = 0;
		Thread.sleep(1000);
		while (num < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			num++;
		}
		System.out.println(tet.getText());
		driver.findElement(By.id("btnclosepaxoption")).click();

		WebElement drpdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdwn = new Select(drpdown);
		dropdwn.selectByVisibleText("USD");
		System.out.println(dropdwn.getFirstSelectedOption().getText());

		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
