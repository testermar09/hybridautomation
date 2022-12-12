package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.xpath("//title")).getText());
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
