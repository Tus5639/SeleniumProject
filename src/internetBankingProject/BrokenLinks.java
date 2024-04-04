package internetBankingProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String url = driver.findElement(By.linkText("REST API")).getAttribute("href");
		SoftAssert a =new SoftAssert();
		
		
		List<WebElement> links = driver.findElements(By.xpath("//ul/li[@class='gf-li']/a"));
		for(WebElement link:links) {
			link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCiode = conn.getResponseCode();
			System.out.println(respCiode);
//			if(respCiode>400) {
//				System.out.println("The broken link is :"+link.getText()+"and response code is"+respCiode);
//				
//			}
			a.assertTrue(respCiode<400,"The broken link is :"+link.getText()+"and response code is"+respCiode) ;
			
			
		}
		a.assertAll();
		

	}

}
