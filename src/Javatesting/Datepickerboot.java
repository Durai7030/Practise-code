package Javatesting;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepickerboot {
    
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
		driver.findElement(By.xpath("//*[text()='Date pickers']")).click();
		driver.findElement(By.partialLinkText("Bootstrap")).click();
		/*driver.findElement(By.xpath("//input[@type='text']")).click();
		Thread.sleep(2000);*/
		//driver.findElement(By.xpath("//input[@type='text']")).click();
		//public void testDAtePicker() throws Exception{

	        //DAte and Time to be set in textbox

	        String dateTime ="12/07/2014";
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        //button to open calendar

	        WebElement selectDate = driver.findElement(By.xpath("//span[@class='input-group-addon']"));
	        selectDate.click();
	    
	    //button to click in center of calendar header

	    WebElement midLink = driver.findElement(By.xpath("//*[text()='June 2018']"));
	    midLink.click();
	    
	    //button to move previous month in calendar

	    WebElement previousLink = driver.findElement(By.xpath("//div[@class='row']")); 
	    previousLink.click();
	    //Thread.sleep(10000);
	   // previousLink.findElement(By.xpath("//*[text()='Jun']")).click();
	    
	   

	        //Split the date time to get only the date part

	        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

	        //get the year difference between current year and year to set in calendar

	        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);	        

	        if(yearDiff!=0){

	            //if you have to move next year

	            if(yearDiff>0){

	                for(int i=0;i< yearDiff;i++){

	                    System.out.println("Year Diff->"+i);

	                    //nextLink.click();

	                }

	            }

	            //if you have to move previous year

	            else if(yearDiff<0){

	                for(int i=0;i< (yearDiff*(-1));i++){

	                    System.out.println("Year Diff->"+i);
	                    previousLink.click();
	                    

	                }

	            }

	        }
	        
	        Thread.sleep(1000);

	        //Get all months from calendar to select correct one

	        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
	        
	        Thread.sleep(1000);

	        //get all dates from calendar to select correct one

	        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
	}

}
