package Javatesting;

import java.util.concurrent.TimeUnit;

import org.apache.xpath.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajax {

	static WebDriver driver;
	
	public static <T> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Ajax Form Submit")).click();
		driver.findElement(By.id("title")).sendKeys("selenium");
		driver.findElement(By.id("description")).sendKeys("selenium is based on the Java script language");
		driver.findElement(By.id("btn-submit")).click();
		String opform =driver.findElement(By.id("submit-control")).getText();
		System.out.println("Text:"+opform);
		/*WebDriverWait seconds=new WebDriverWait(driver, 5);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Form submited Successfully!']"));
		seconds.until(ExpectedConditions.visibilityOf(ele));*/
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(10, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);*/
		//WebElement clickseleniumlink =driver.findElement(By.xpath("//*[text()='Form submited Successfully!']"));
		String ele = driver.findElement(By.id("submit-control")).getText();
		Thread.sleep(2000);
		System.out.println("Text:"+ele);
		
		
	}	

}
