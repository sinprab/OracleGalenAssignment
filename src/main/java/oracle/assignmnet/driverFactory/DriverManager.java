package oracle.assignmnet.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import oracle.assignmnet.deviceFactory.DeviceFactory;
import oracle.assignmnet.utilities.PropertyReader;

public class DriverManager {

	public static WebDriver driver;
	

	public static void setDriver() {
		
		try
		{
		String browser = PropertyReader.getProperty("browser");
		String device = PropertyReader.getProperty("device");
		String driverPath;
		switch(browser)
		{
		case "firefox" : driverPath	= PropertyReader.getProperty("firefoxDriverPath");
						 System.setProperty("webdriver.gecko.driver",driverPath);
						 driver = new FirefoxDriver();
						 driver.manage().window().setSize(DeviceFactory.getDeviceDimesion(device));
						 break;
						 
		case "chrome" : driverPath	= PropertyReader.getProperty("chromeDriverPath");
		 				System.setProperty("webdriver.chrome.driver",driverPath);
		 				driver = new ChromeDriver();
		 				System.out.println("****************"+device);
		 				driver.manage().window().setSize(DeviceFactory.getDeviceDimesion(device));
		 				break;
		
		default 	 : System.out.println("Incorrect Broswer Name !!");
					   driver = null;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
