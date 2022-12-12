package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.zoho.com/sign/signup.html");
		
		//driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		System.out.println((String) js.executeScript("return document.readyState;"));
		
		Thread.sleep(5000);
		
		System.out.println((String) js.executeScript("return document.readyState;"));
		
		
		driver.quit();
		
		

	}

}
