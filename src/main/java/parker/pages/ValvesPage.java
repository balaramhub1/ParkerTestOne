package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class ValvesPage extends TestBase{
	
	public ValvesPage(WebDriver dr){
		PageFactory.initElements(drv, this);
		this.drv=dr;
	}

}
