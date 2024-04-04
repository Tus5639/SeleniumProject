package testNG;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testset1 {
	@BeforeMethod
	public void demo() {
		System.out.println("hello before method");
	}
	
	@Test
	public void demo1() {
		System.out.println("hello test");
	}
	
	@Test
	public void demo8() {
		System.out.println("hello test");
	}
	
	@AfterSuite
	public void demo_2() {
		System.out.println("hello after suite");
	}
	@AfterMethod
	public void demo_7() {
		System.out.println("hello after method");
	}
	@AfterGroups
	public void demo_9() {
		System.out.println("group");
	}
	
	@BeforeClass
	public void meow() {
		System.out.println("meow");
	}
	
}
