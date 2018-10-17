package Javatesting;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
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
		WebElement webele=driver.findElement(By.id("multi-select"));
		Select sel=	new Select(webele);
		
		Actions example=new Actions(driver);
		Action click=example.sendKeys(Keys.CONTROL).build();
		click.perform();
		sel.selectByIndex(0);
		sel.selectByIndex(1);
		sel.selectByIndex(2);
		//sel.selectByIndex(3);
		Thread.sleep(2000);
		driver.findElement(By.id("printAll")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.className("getall-selected")).getText();
		System.out.println(text);
		
	}

}
