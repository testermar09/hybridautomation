package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import util.UtilKit;

public class ToVerifyValidLoginDetails extends BaseTest{
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		return UtilKit.getData("com.adactin.hotelapp", "TC101");
	}
	
	@Test(dataProvider = "getData")
	public void toVerifyValidLoginDetailsTest(String un,String pwd,String expTitle,String helloU)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		//open browser
		
		app.openBrowser("chrome");
		
		app.navigate("url");
		
		app.takeScreenShot();
		
		app.type("username_xpath", un);
		
		app.type("password_name", pwd);
		
		app.click("login_id");
		
		app.takeScreenShot();
		
		app.validateTitle(expTitle);
		
		app.quit();
		
		
		
	}

}
