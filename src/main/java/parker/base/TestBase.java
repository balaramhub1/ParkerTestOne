package parker.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import parker.listeners.DriverEventListener;

public class TestBase {
	
	public WebDriver drv;
	public Properties prop;
	public DriverEventListener drivListener;
	public EventFiringWebDriver e_drv;
	public Logger jlog=Logger.getLogger(TestBase.class.getName());
	
	
	
	public void initSetup(){
		String log4jConfigPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		readProp();
		getDriver(prop.getProperty("browser"));
		
		e_drv=new EventFiringWebDriver(drv);
		drivListener=new DriverEventListener();
		
		e_drv.register(drivListener);
		drv=e_drv;
		
		getUrl(prop.getProperty("url"));
	}
	
	public WebDriver getDriver(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			jlog.info("Instance of "+browser+" browser created");
			drv=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			jlog.info("Instance of "+browser+" browser created");
			drv=new FirefoxDriver();
		}
		return drv;
	}
	
	public void getUrl(String url){
		drv.get(url);
		jlog.info("Navigating to : "+url);
		drv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		drv.manage().window().maximize();
	}
	
	public void readProp(){
		try{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/parker/config/config.properties");
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
