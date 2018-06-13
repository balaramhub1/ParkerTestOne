package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class RegistrationPage extends TestBase{
	
	public RegistrationPage(WebDriver dr){
		PageFactory.initElements(drv, this);
		this.drv=dr;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Create An Account')]")
	WebElement createAccSection;

	public boolean createAccSectionDisplayed(){
		return createAccSection.isDisplayed();
	}
}
