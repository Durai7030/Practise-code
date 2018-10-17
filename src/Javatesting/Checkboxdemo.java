package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxdemo {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Checkbox Demo")).click();
		driver.findElement(By.id("isAgeSelected")).click();
		String text=driver.findElement(By.id("txtAge")).getText();
		System.out.println("value:"+text);
		
		if(text.contains("Check box"))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		
		boolean value=driver.findElement(By.id("isAgeSelected")).isSelected();
		System.out.println("output:"+value);
		
//		driver.findElement(By.id("isAgeSelected")).click();
//		String text1=driver.findElement(By.id("txtAge")).getText();
//		System.out.println("value:"+text1);
		
		driver.close();
	}

}
