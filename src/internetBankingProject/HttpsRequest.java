package internetBankingProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HttpsRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://expired.badssl.com/
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
