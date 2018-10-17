package Selenium;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filedownload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String downloadfilepath="/home/kadadmin/Documents/Download - Selenium";
		HashMap<String, Object> chrome=new HashMap<String,Object>();
		chrome.put("download.default_directory",downloadfilepath);
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chrome);
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.get("http://192.168.2.17:97/");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demosathish");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("Pass@123");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		driver.findElement(By.xpath("//span[text()='DELL000153']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddComponent_input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_btnCaseDocument_input")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCaseDocument_input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[text()='Upload Document(s)']")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_rauCaseDocumentfile0")).sendKeys("/home/kadadmin/Downloads/Sample Documents/ID.jpg");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_btnAddCaseDocument_input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkFileName")));
		String filename=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkFileName")).getText();
		filename=filename.replaceAll("[0-9]","");
		System.out.println("value:"+filename);
		
		Filedownload obj=new Filedownload();
		obj.deletefile(new File(downloadfilepath));
		obj.download(driver);
		String name=obj.returnfile(new File(downloadfilepath)) ;
		name=name.replaceAll("[0-9]","");
		System.out.println(""+name);
		
		if(filename.equals(name))
		{
			System.out.println("Match");
		}
		else
		{
			System.out.println("Mismatch");
		}
		
		
	}
	public void download(WebDriver driver) {
		
		// TODO Auto-generated method stub
		WebDriverWait wait1=new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkFileName")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkbtnDownload1")).click();
		
 
	}
	public void deletefile(File file) 
	{
		File [] file1=file.listFiles();
		for(File file2 : file1)
		{
			file2.delete();
		}
	}


	private String returnfile(File filename) 
	{
		// TODO Auto-generated method stub
		File [] filename1=filename.listFiles();
		int value= filename1.length;
		if (value==1)
		{
		 String name =filename1[0].getName();
		 return name;
		} 
		else 
		{
			return null;
		}
       
	}
}
