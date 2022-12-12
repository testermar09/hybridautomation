package keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords {
	
	public WebDriver driver;
	public Properties prop;
	public Properties envProp;
	public SoftAssert softAssert;
	public static ExtentTest test;
	public void openBrowser(String browser)
	{
		log("Opening Browser "+browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		log("Browser has been maximized");
	}
	
	
	//central method to extract element
	
	public WebElement getElement(String locatorKey)
			{
				
		
				//check the presence
		
		          if(!isElementPresent(locatorKey))
		          {
		        	  //report failure
		        	  
		        	  System.out.println("Element is not present "+locatorKey);
		          }
		        //check the visibility
		          
		          if(!isElementVisible(locatorKey))
		          {
		        	  //report failure
		        	  
		        	  System.out.println("Element is not visible "+locatorKey);
		          }
				
			    WebElement element=driver.findElement(getLocator(locatorKey));
		
		
				return element;
		
			}
	
	//true - present in DOM
	//false - not present
	
	public boolean isElementPresent(String locatorKey)
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}
	
	//true - visible
	//false - not visible
	
	public boolean isElementVisible(String locatorKey)
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}
	
	
	public By getLocator(String locatorKey)
	{
		
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_css"))
		{
			by=By.cssSelector(prop.getProperty(locatorKey));
		}
		
		return by;
		
	}
	
	public void click(String locatorKey)
	{
		System.out.println("Clicking on "+locatorKey);
		getElement(locatorKey).click();
	}
	
	public void clickEnterButton(String locatorKey)
	{
		
		getElement(locatorKey).sendKeys(Keys.ENTER);
	}
	
	public void clear(String locatorKey)
	{
		getElement(locatorKey).clear();
	}
	
	public void log(String msg)
	{
		test.log(Status.INFO, msg);
	}
	
	public void navigate(String urlKey)
	{
		log("Navigating to URL "+envProp.getProperty(urlKey));
		driver.get(envProp.getProperty(urlKey));
	}
	
	
	public String getText(String locatorKey)
	{
		return getElement(locatorKey).getText();
	}
	
	public void quit()
	{
		driver.quit();
	}
	
	public void type(String locatorKey, String data)
	{
		getElement(locatorKey).sendKeys(data);
		
		log("Entered text "+data+" in to text box using locator key"+locatorKey);
	}
	
	public void selectByVisibleText(String locatorKey, String data)
	{
		new Select(getElement(locatorKey)).selectByVisibleText(data);
	}

	public void wait(int time)
	{
		
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	public void waitForPageToLoad()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int i=0;
		while(i!=10)
		{
		String state=(String) js.executeScript("return document.readyState;");
		
		if(state.equals("complete"))
			break;
		else
		  wait(2);
		
		}
		
		
	}
	
	
	public String getTitle()
	{
		
		
		return driver.getTitle();
		
	}
	public void takeScreenShot()
	{
		
		//Screenshot folder
		
		String screenshotDirPath=System.getProperty("user.dir")+"\\screenshots";
		
		File screenshotDir=new File(screenshotDirPath);
		
		screenshotDir.mkdir();
		
		//filename of the screenshot
		
		Date d=new Date();
		
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		//take screenshot
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(screenshotDirPath+"\\"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotDirPath+"\\"+screenshotFile);
		
	}

	

	
}
