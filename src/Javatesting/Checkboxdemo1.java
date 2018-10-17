package Javatesting;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxdemo1 {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Driver - Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Checkbox Demo")).click();
		driver.findElement(By.id("check1")).click();
		List<WebElement> list = driver.findElements(By.xpath("//*[@type='checkbox'][@class='cb1-element']"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println("value:" + list);
			boolean bool = list.get(i).isSelected();
			if (bool) {
				System.out.println("passed");
				continue;
			} else {
				System.out.println("failed");
				break;
			}
		}
		driver.close();

	}
}
