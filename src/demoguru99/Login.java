package demoguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	static WebDriver driver;
	private static String baseUrl;

	public static void main(String args[])
	{
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		//String baseUrl="http://www.demo.guru99.com/V4/";
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl=Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME,TimeUnit.SECONDS);
		driver.get(baseUrl+"/V4/");
	
		String actualTitle;
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(Util.Username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(Util.Password);
		driver.findElement(By.name("btnLogin")).click();
		
		actualTitle=driver.getTitle();
		if(actualTitle.contains(Util.Except_Title))
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
