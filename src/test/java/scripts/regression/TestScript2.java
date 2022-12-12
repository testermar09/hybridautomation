package scripts.regression;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestScript2 extends BaseTest {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("In Before Method of TS2");
	}
	
	@Test
	public void m4()
	{
		System.out.println("In m4 method");
	}
	
	@Test
	public void m5()
	{
		System.out.println("In m5 method");
	}
	
	@Test
	public void m6()
	{
		System.out.println("In m6 method");
	}
	
	

}
