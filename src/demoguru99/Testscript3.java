package demoguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testscript3 {
	static WebDriver driver;
	private static String baseUrl;
	
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "/home/kadadmin/Downloads/Drivers/Driver - Chrome/chromedriver");
		driver=new ChromeDriver();
		baseUrl = Util1.BASE_URL;
		driver.manage().timeouts()
			.implicitlyWait(Util1.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(baseUrl + "/V4/");
		
		String[][] testData = Util1.getDataFromExcel(Util1.FILE_PATH,Util1.SHEET_NAME, Util1.TABLE_NAME);
	String username, password;
	String actualTitle;
	String actualBoxtitle;
	
	for(int i=0;i<testData.length;i++)
	{
		username= testData[i][0];
		password= testData[i][1];
		 driver.findElement(By.name("uid")).clear();
		 driver.findElement(By.name("uid")).sendKeys(username);
		 driver.findElement(By.name("password")).clear();
		 driver.findElement(By.name("password")).sendKeys(password);
		 driver.findElement(By.name("btnLogin")).click();
		 
		 try
		 {
			 Alert alt = driver.switchTo().alert();
				actualBoxtitle = alt.getText(); 
				alt.accept();
				if (actualBoxtitle.contains(Util1.EXPECT_ERROR)) 
				{
				    System.out.println("Test case SS[" + i + "]: Passed"); 
				} 
				else 
				{
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
			 
		 }
		 catch(NoAlertPresentException Ex)
		 {
			 actualTitle = driver.getTitle();
				if (actualTitle.contains(Util1.EXPECT_TITLE)) {
				    System.out.println("Test case SS[" + i + "]: Passed");
				} else {
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
			 
		 }

	}
	driver.close();

	}
	
	

}
