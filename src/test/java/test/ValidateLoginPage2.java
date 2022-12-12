package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateLoginPage2 {
	
	@Test
	public void validateLoginPageTest() {
		
		SoftAssert softAssert=new SoftAssert();
	
		System.out.println("Test case started..........");
		
		softAssert.assertEquals(5, 6, "Numbers are not equal");
		
		System.out.println("Soft assert 1 is completed ..");
		
		
		softAssert.assertTrue("Hello".equals("hello"), "String are alike");
		
		System.out.println("Soft assert 2 is completed ..");
		
		System.out.println("Test case completed ....");
		
		softAssert.assertAll();		
		
	}

}
