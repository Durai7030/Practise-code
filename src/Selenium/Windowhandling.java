package Selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.17:97/");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demosathish");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("Pass@123");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		String window=driver.getWindowHandle();
		System.out.println("Value= "+window);	
		Thread.sleep(10000);
		driver.findElement(By.id("CaseTracker")).click();
		Set<String> handle=driver.getWindowHandles();
		ArrayList<String> handles=new ArrayList<String>(handle);
		driver.switchTo().window(handles.get(1).toString());
		String text=driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_tbltitle']//h2")).getText();
		System.out.println("Value= "+text);
		driver.close();
		driver.switchTo().window(window);
		String text1=driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblhdr']")).getText();
		System.out.println("Value= "+text1);
		driver.close();
	}

}
