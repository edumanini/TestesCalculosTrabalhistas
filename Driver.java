import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
	public static WebDriver driver;
	public static String baseUrl = "http://www.catho.com.br";
	
	public static WebDriver createDriver(){
		if(driver==null){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
		}
		
	    return(driver);
	}
}
