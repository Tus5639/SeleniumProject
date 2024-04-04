package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
  @AfterTest
  public void Maa() {
	  System.out.println("Hello After Test ");
	  
  }
  
  @BeforeTest
  public void Papa() {
	  System.out.println("Hello Before Test");
	  
  }
  
  @BeforeSuite
  public void Dadi() {
	  System.out.println("Hello Before SUite");
	  
  }
}
