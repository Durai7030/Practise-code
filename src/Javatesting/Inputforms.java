package Javatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Inputforms {
	
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
		driver.findElement(By.partialLinkText("Input Form Submit")).click();
		firstname();
		lastname();
		email();
		//phone();
		Inputforms obj=new Inputforms();
		obj.phone();
		address2();
		city();
		state();
		zipcode();
	}
 public static void firstname()
 {
	 driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Sathis");
	 
 }
 public static void lastname()
 {
	 driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Pandi");
 }
 public static void email() 
 {
	 driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmaill.com");
 }
 public  void phone()
 {
 driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9587485964");	
}
 public static void address2()
 {
	 driver.findElement(By.xpath("//input[@name='address']")).sendKeys("7th cross street");
 }
 public static void city()
 {
	 driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");
 }
 public static void state()
 {
	 WebElement element=driver.findElement(By.xpath("//input[//*[@id='contact_form']/fieldset/div[7]/div/div/select]"));
	 Select sel=new Select(element);
	 sel.deselectByVisibleText("Texas");
	 Select dropdown = new Select(driver.findElement(By.xpath("//input[//*[@id='contact_form']/fieldset/div[7]/div/div/select]")));
	 dropdown.selectByVisibleText("Texas"); 	
	 
	 
 }
 public static void zipcode()
 {
	 driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("12356");
	
}
}
