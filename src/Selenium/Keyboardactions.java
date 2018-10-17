package Selenium;



import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Keyboardactions {

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
		drop.selectByIndex(1);
        Thread.sleep(3000);
		WebElement txt=driver.findElement(By.xpath("//span[text()='WSA000348']"));
		Actions object=new Actions(driver);
		Action seriesOfActions =object.moveToElement(txt).doubleClick().sendKeys(Keys.CONTROL).sendKeys("c").build();
		
		seriesOfActions.perform();
		
		driver.findElement(By.id("CaseTracker")).click();
		
		ArrayList<String> handle= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handle.get(1).toString());
		Thread.sleep(2000);
		driver.findElement(By.id("searchBox")).sendKeys(Keys.CONTROL+"v");
		
//		WebElement txt1=driver.findElement(By.id("searchBox"));
//		Action seriesOfActions1=object.moveToElement(txt1).click().sendKeys(Keys.CONTROL).sendKeys("V").build();
//		seriesOfActions1.perform();
		

	}

}
