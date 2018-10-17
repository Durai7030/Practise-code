package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Twofields {

	static WebDriver driver;
	
	public static void main(String[] args) {
		int a,b;
		a=11;
		b=12;
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
			driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(Integer.toString(a));
			driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(Integer.toString(b));
			driver.findElement(By.xpath("//*[text()='Get Total']")).click();
			String value=driver.findElement(By.id("displayvalue")).getText();
			System.out.println("value :"+value);
			if(value.equals(Integer.toString(a+b)))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			
			driver.close();
	}

}
