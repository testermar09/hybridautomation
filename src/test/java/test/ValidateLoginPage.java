package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateLoginPage {
	
	@Test
	public void validateLoginPageTest() {
		
	
	
		System.out.println("Test case started..........");
		
		Assert.assertEquals(5, 6, "Numbers are not equal");
		
		System.out.println("Hard assert 1 is completed ..");
		
		
		Assert.assertTrue("Hello".equals("hello"), "String are alike");
		
		System.out.println("Hard assert 2 is completed ..");
		
		System.out.println("Test case completed ....");
		
		
	}

}
