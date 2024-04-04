package testNG;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class academyLogin {
	@Test
	public static void hello() throws IOException, InterruptedException {
		
		//Initialise Browser driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\internetBankingProject\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Define values 
		String username = "Tushar";
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		
		//Launch Browser
		driver.get(url);
		driver.manage().window().maximize();
	
		//Enter Credentials
		//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		//driver.findElement(By.cssSelector("[placeholder='Name']")).clear();
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("AEZAKMI");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,\"submit\")]")).click();
		Thread.sleep(1000);
		String error = driver.findElement(By.xpath("//p[contains(@class,'error')]")).getText();
		assertEquals(error, "* Incorrect username or password");
		
		//move to reset password
//		driver.findElement(By.xpath("//div/a")).click();
//		driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys(name);
		
		String password = getPassword(driver);
		
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(@class,\"submit\")]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		driver.findElement(By.xpath("//*[text()=\"Log Out\"]")).click();
		System.out.println("ENds Here");
		//close the Browser
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		String name = "rahul";
		driver.get(url);
		driver.findElement(By.xpath("//div/a")).click();
		driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/button[2]")).click();
		
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String tempPassword = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		
		String[] password1 = tempPassword.split("'");
		String password = password1[1].split("'")[0];
		//String password =pass[0];
		return password;
	}
//	String passwordText =driver.findElement(By.cssSelector("form p")).getText();
//
//	//Please use temporary password 'rahulshettyacademy' to Login.
//
//	String[] passwordArray = passwordText.split("'");
//
//	// String[] passwordArray2 = passwordArray[1].split("'");
//
//	// passwordArray2[0]
//
//	String password = passwordArray[1].split("'")[0];
}

