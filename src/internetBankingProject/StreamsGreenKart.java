	package internetBankingProject;
	
	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	
	public class StreamsGreenKart {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	WebDriver driver = new ChromeDriver();
	List<String> price ;
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.cssSelector("thead tr th span")).click();
	List<WebElement>element = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	List<String> Original_List = element.stream().map(s->s.getText()).toList();
	
	List<WebElement>element_new = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	List<String> element_sort = element_new.stream().map(s->s.getText()).sorted().toList();
	Assert.assertTrue(element_sort.equals(Original_List));
	
	do {
		List<WebElement> veg_fruit_name = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	 price = veg_fruit_name.stream().filter(s->s.getText().contains("Wheat"))
	.map(s->getPrice(s)).collect(Collectors.toList());
	
	price.forEach(s->System.out.println(s));
	
	if((price.size()<1)) {
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}}
	while(price.size()<1);
	
		System.out.println("Validation success");
		driver.close();}
		
	
		
	public static String getPrice(WebElement s ) {
		String pricevalue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
			return pricevalue;
		}
	
	}
	
