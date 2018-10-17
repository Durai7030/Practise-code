package Javatesting;



import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Seleniumeasy {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/home/kadadmin/Downloads/Driver - Chrome/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor example=(JavascriptExecutor)driver;
		WebElement ele =driver.findElement(By.xpath("//*[text()='All Examples']"));
		
		example.executeScript("arguments[0].scrollIntoView(true);", ele);
		
			driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
			driver.findElement(By.partialLinkText("Simple Form Demo")).click();
			driver.findElement(By.xpath("//Input[@type='text']")).sendKeys("Selenium");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Show Message']")).click();
			String value=driver.findElement(By.id("display")).getText();
			if(value.equals("Selenium"))
			{
				System.out.println("pass");
				
			}
			else {
				System.out.println("failed");
			}
			driver.close();
		}
		
		

	}


