package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.17:97/");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demosathish");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("Pass@123");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		Thread.sleep(10000);
		Select drop=new Select(driver.findElement(By.id("ddlAct")));
		drop.selectByIndex(2);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='DELL000024']")).click();
		
		driver.switchTo().frame(0);
		String text=driver.findElement(By.xpath("//legend[text()='Address Details']")).getText();
		System.out.println("Value= "+text);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Education']")).click();
		
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		String text1=driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_wrapperouter1']//tr//td[2]//legend")).getText();
		System.out.println("Value= "+text1);
		driver.close();
		

	}

}
