package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}

	
}
