package demochecks360;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demoguru99.Util;


public class Login {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.17:97/Login.aspx");
		
		String actualTitle;
		
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).clear();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demoemp");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).clear();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("pass@123");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		
		Thread.sleep(7000);
		actualTitle=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblhdr")).getText();
		if(actualTitle.contains("Home Page"))
		{
			System.out.println("TestCase : Passed");
		}
		else
		{
			System.out.println("Testcase: Failed");
		}
		driver.close();
	}

}
