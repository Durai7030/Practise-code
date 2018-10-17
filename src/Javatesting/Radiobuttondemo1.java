package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobuttondemo1 {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "female";
		String names = name.toLowerCase();
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Driver - Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Radio Buttons Demo")).click();
		switch (names) {
		case "male":
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			driver.findElement(By.id("buttoncheck")).click();
			break;

		case "female":
			driver.findElement(By.xpath("//input[@value='Female']")).click();
			driver.findElement(By.id("buttoncheck")).click();
			break;

		default:
			System.out.println("invalid");
			break;
		}
		String text=driver.findElement(By.xpath("//p[@class='radiobutton']")).getText();
		System.out.println("Result:"+text);
		String op = "Radio button '"+name+"' is checked";
		if(op.equalsIgnoreCase(text))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.close();
	}

}
