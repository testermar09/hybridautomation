package keywords;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class ValidationKeywords extends GenericKeywords {
	
	
	public void validateElementPresent(String locatorKey)
	{
		
		boolean result=isElementPresent(locatorKey);
		
		Assert.assertTrue(result, "Element is not present" );
	}
	
	
	public void validateSelectedValueInDropDown(String locatorKey,String option)
	{
		Select s1=new Select(getElement(locatorKey));
		
		String text=s1.getFirstSelectedOption().getText();
					
		Assert.assertEquals(text, option,"Option not selected in dropdown");
	}
	
	public void validateTitle(String expectedTitle)
	{
		
		Assert.assertEquals(getTitle(), expectedTitle,"Expected Title doesn't match with Actual Title");
		
		log("Titles Matched "+"Expected is "+expectedTitle+"\t Actual is "+getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
