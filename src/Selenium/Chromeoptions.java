package Selenium;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		//option.setHeadless(true);

        HashMap<String, Object> config = new HashMap<String, Object>();
        config.put("profile.default_content_settings.popups", 1);
		option.setExperimentalOption("prefs", config);
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com/?gclid=EAIaIQobChMImoP5w-v93QIVjCQrCh1McAmlEAAYASAAEgKcb_D_BwE");
		String value=driver.getTitle();
		System.out.println("op="+value);
		//driver.close();
		
		
		
		

	}

}
