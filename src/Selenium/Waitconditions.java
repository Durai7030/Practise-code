package Selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitconditions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		 WebDriver driver=new ChromeDriver(option);
		 
		 //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver,15);
		 driver.get("http://192.168.2.17:97/Login.aspx");
		 driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("demosathish");
		 driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("Pass@123");
		 driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
		 //Thread.sleep(1000);
//		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loading-bar-spinner")));
//		 Boolean obj=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		 
		 Wait<WebDriver> ele= new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		 WebElement ele1=ele.until(new Function<WebDriver,WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				//return driver.findElement(By.id("ddlAct"));
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Boolean obj=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
			if(obj)
			{
				return driver.findElement(By.id("ddlAct"));
			}
			else
			{
				return null;
				
			}
				//return null;			
			}
		});
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlAct")));
		 ele1.click();
		 
		 
		 
		 
		 
		 

	}

}
