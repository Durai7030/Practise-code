package Selenium;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fileupload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait=new WebDriverWait(driver, 15);
		driver.get("http://192.168.2.17:97/");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtUserName")).sendKeys("demosathish");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPassword")).sendKeys("Pass@123");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnLogin")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		driver.findElement(By.xpath("//span[text()='DELL000153']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddComponent_input")).click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_btnCaseDocument_input")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCaseDocument_input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[text()='Upload Document(s)']")));
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_rauCaseDocumentfile0")).sendKeys("/home/kadadmin/Downloads/Sample Documents/ID.jpg");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl08_rauCaseDocumentfile0")).sendKeys("/home/kadadmin/Downloads/Sample Documents/CREDITVerification.pdf");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_btnAddCaseDocument_input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkFileName")));
		String filename=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl06_lnkFileName")).getText();
		filename=filename.replaceAll("[0-9]","");
		System.out.println("value:"+filename);
		
		String filename1=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rwCaseDocument_C_grdCaseDocument_ctl00_ctl08_lnkFileName")).getText();
		filename1=filename1.replaceAll("[0-9]","");
		System.out.println("value:"+filename1);
		
		String fullPath = "/home/kadadmin/Downloads/Sample Documents/CREDITVerification.pdf";
		int index = fullPath.lastIndexOf("/");
		String fileName1 = fullPath.substring(index + 1);
		System.out.println("value2:"+fileName1);
//		
//		Path p = Paths.get("/home/kadadmin/Downloads/Sample Documents/ID.jpg");
//		String file = p.getFileName().toString();
//		System.out.println("value2:"+file);
//		
//		File file1 = new File("/home/kadadmin/Downloads/Sample Documents/ID.jpg");
//		String file2=file1.getName().toString();
//		System.out.println("value2:"+file2);
//		
//		
		
		if(filename1.equals(fileName1))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
//		
	}

}
