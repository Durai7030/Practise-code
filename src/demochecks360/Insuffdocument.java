package demochecks360;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Insuffdocument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		driver.get("http://192.168.2.17:97/login.aspx");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demosathish");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("Demo@002");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		String text=driver.findElement(By.id("ctl00_lblUsername")).getText();
		if(text.contains("Welcome"))
		{
		 System.out.println("Login Successfully");	
		}
		else
		{
			System.out.println("Login Failed");
		}
		WebElement waiting;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		//waiting=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Actions']")));
		driver.findElement(By.id("btnActions")).click();
		waiting=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ddlAct_Input")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdTaskList_ctl00_ctl04_btnClearInsuff")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdwInsuffClearWindow_C_grdInsuffClear_ctl00_ctl06_btnUploadInsuffDocuments")).click();
	}

}
