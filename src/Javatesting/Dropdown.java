package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Select Dropdown List")).click();
		WebElement drop=driver.findElement(By.id("select-demo"));
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("Monday");
		String output=driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
		System.out.println("Result:"+output);
		if(output.contains("Monday"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		driver.close();
		
		

	}

}
