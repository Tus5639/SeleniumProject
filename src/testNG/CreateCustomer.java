package testNG;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateCustomer {
	@Test
	public static void notion() {
		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\HP\\OneDrive\\Desktop\\internetBankingProject\\drivers\\chromedriver.exe");

		String url = "https://demo.guru99.com/V1/index.php";
		System.out.println("Window is launched in a new Window");
		driver.get(url);

		// Maximize the window
		driver.manage().window().maximize();

		String title = driver.getTitle();

		System.out.println("Title of the WebPage is: " + title);

		// login credentials

		// Wait Time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Duration of 5 Seconds");

		// username
		driver.findElement(By.name("uid")).sendKeys("mngr547376");
		;
		System.out.println("User enters the usename in Login Page");

		// password
		driver.findElement(By.name("password")).sendKeys("enenyhA");
		;
		System.out.println("User enters the password in the Login Page");

		// search button
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("User hits on login(#Submit) button to proceed");

		System.out.println("User enters on Homepage");

		driver.findElement(By.xpath("//a[contains(@href,'Manager')]")).click();
		System.out.println("User clicks on Manager Tab");

		// Create Customer Tab

		driver.findElement(By.xpath("//a[contains(@href,'addcustomer')]")).click();
		System.out.println("User clicks on Create Customer Tab");

		String valid_value = "Add New Customer";

		String lsit = driver.findElement(By.xpath("//p[contains(@class,\"heading\")]")).getText();
		System.out.println(lsit);

		// Comparing titles

		if (lsit.equals(valid_value)) {
			System.out.println("Add New Customer tab is open");
		} else {
			System.out.println("Wrong Tab");
			driver.close();
		}

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("./screenshot/Customer_add.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/// Fill out the details for new customer

		driver.findElement(By.name("name")).sendKeys("Shraiya Gupta");
		System.out.println("User enters customer name");

		driver.findElement(By.name("rad1")).click();
		System.out.println("User selects gender");

		driver.findElement(By.name("dob")).sendKeys("24/04/1997");
		System.out.println("User enters customer D.O.B");

		driver.findElement(By.name("addr")).sendKeys("XYZ, Gurugram 122001 HR");
		System.out.println("User enters customer Address");

		driver.findElement(By.name("city")).sendKeys("Dausa");
		System.out.println("User enters customer City");

		driver.findElement(By.name("state")).sendKeys("Rajasthan");
		System.out.println("User enters customer State");

		driver.findElement(By.name("pinno")).sendKeys("122001");
		System.out.println("User enters customer PIN No.");

		driver.findElement(By.name("telephoneno")).sendKeys("1234567890");
		System.out.println("User enters customer Mobile Number");

		driver.findElement(By.name("emailid")).sendKeys("xyz123@email.com");
		System.out.println("User enters customer E-mail");

		driver.findElement(By.name("sub")).click();
		System.out.println("User enters submit button");

		// handling alert
		driver.switchTo().alert().accept();
		System.out.println("User handles alert");

		driver.close();
		System.out.println("Windows is closed Execution is Completed.");
	}
}