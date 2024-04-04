package internetBankingProject;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login   {

	public static void main(String[] args)throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\internetBankingProject\\drivers\\chromedriver.exe");
		 String url = "https://demo.guru99.com/V1/index.php";
		 System.out.println("Window is launched in a new Window");
		 driver.get(url);
		 driver.manage().window().maximize();
		 //Thread.sleep(5000);
		 String title = driver.getTitle();
		 
		 System.out.println("Title of the WebPage is: "+title);
		 
		 //login credentials
		 
		 driver.findElement(By.name("uid")).sendKeys("mngr547376");;
		 System.out.println("User enters the usename in Login Page");
		 driver.findElement(By.name("password")).sendKeys("enenyhA");;
		 System.out.println("User enters the password in the Login Page");
		 driver.findElement(By.name("btnLogin")).click();;
		 System.out.println("User hits on login(#Submit) button to proceed");
		 
		 //Thread.sleep(1000);
		 
		 
		 //Screenshot to take
		 //TakesScreenshot scr = ((TakesScreenshot)driver);
		 System.out.println("User takes a Screenshot");
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		 try {
	            FileUtils.copyFile(screenshotFile, new File("./screenshot/screenshit.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		
		 //New Home Page
		 //driver.wait();
		 String homepage = driver.getTitle();
		 System.out.println("Page title for home page after login screen is: "+homepage);
		 
		 
		 //TakesScreenshot scr = ((TakesScreenshot)driver);
		 File screenshotFile_1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		 try {
	            FileUtils.copyFile(screenshotFile_1, new File("./screenshot/screenspot2.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		
		 
		 driver.close();
		 System.out.println("Window is closed");

	}

}
