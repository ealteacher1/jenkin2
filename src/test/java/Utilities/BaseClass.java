package Utilities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
    
	@Parameters({"browser","websiteURL"})
	@BeforeMethod
	public void beforeMethod(String browserName,String url) throws InterruptedException {
		Ibrowser(browserName, url);	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		System.out.println("Browser is Closed");
	}




	public void Ibrowser(String BrowserName,String URL) throws InterruptedException {

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(URL);	 	  
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(4000);	   	
		}

		else if(BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(URL);		   
			driver.manage().window().maximize();
			Thread.sleep(4000);}

	}






}
