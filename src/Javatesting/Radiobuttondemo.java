package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobuttondemo {

	static WebDriver driver;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name= "female";
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Driver - Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Radio Buttons Demo")).click();
//		driver.findElement(By.xpath("//input[@value='"+name+"']")).click();
		
		
		if (name.equalsIgnoreCase("Male")) {
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			driver.findElement(By.id("buttoncheck")).click();
		} 
		else if(name.equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath("//input[@value='Female']")).click();
			driver.findElement(By.id("buttoncheck")).click();
		}
			else {
				System.out.println("invalid");
		}
		
		}
		
	}


