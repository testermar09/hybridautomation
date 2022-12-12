package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords{
	
	public ApplicationKeywords()
	{
		
		try {
			FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\properties\\env.properties");
			envProp=new Properties();
			envProp.load(fis1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis2=new FileInputStream(System.getProperty("user.dir")+"\\properties\\locators.properties");
			prop=new Properties();
			prop.load(fis2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softAssert=new SoftAssert();
		
	}
	
	public void setReport(ExtentTest test)
	{
		this.test=test;
	}

}
