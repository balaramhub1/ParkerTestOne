package parker.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver drv;
	@BeforeTest
	public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		drv=new ChromeDriver();
		drv.get("https://ph.parker.com/in/en/Login?myAcctMain=1");
		Thread.sleep(3000);
		
	}
  @Test
  public void f() throws InterruptedException {
	  System.out.println("Driver value is : "+drv);
	  
	  //List<WebElement> topMenuList=drv.findElements(By.xpath(""))
	  
	  System.out.println(drv.findElement(By.xpath("//a[@href='https://ph.parker.com/in/en/Login?myAcctMain=1']")));
	  drv.findElement(By.xpath("//a[@href='https://ph.parker.com/in/en/Login?myAcctMain=1']")).click();
	  Thread.sleep(3000);
	  drv.navigate().to("https://ph.parker.com/webapp/wcs/stores/servlet/LogonForm?catalogId=14051&langId=-1&storeId=14761&krypto=US0X8G4EJptvEMs1deKgKyvEY9jCOqrfUpLxVE83P%2Fe4pu8NEKoTIHsL2vP1G9AEfHsJKzieCNwoM2qO8gRnYA%3D%3D&ddkey=http%3Ain%2Fen%2FLogin");
  }
  
  @AfterTest
  public void tearDown() throws InterruptedException{
	  Thread.sleep(3000);
	  drv.close();
  }
}
