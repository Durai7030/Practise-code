package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobuttondemo2 {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sex = "Female";
		String agegroup = "5 - 15";
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Driver - Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumeasy.com/test/");
		JavascriptExecutor sample = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[text()='All Examples']"));
		sample.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
		driver.findElement(By.partialLinkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//*[@value='" + sex + "'][@name='gender']")).click();
		driver.findElement(By.xpath("//input[@value='" + agegroup + "']")).click();
		driver.findElement(By.xpath("//*[text()='Get values']")).click();
		String output = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		System.out.println("Result:" + output);
		String op = "Sex : " + sex + "\n" + "Age group: " + agegroup;
		System.out.println(op);
		if (op.equalsIgnoreCase(output)) {

			System.out.println("Passed");

		} else {
			System.out.println("Failed");
		}
		driver.close();
	}

}
