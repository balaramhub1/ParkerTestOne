package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class UserPage extends TestBase{

	public UserPage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccountLink;
	
	@FindBy(xpath="//a[@title='Sign Out']")
	WebElement signOutLink;
	
	public MyAccountPage clickMyAccountLink(){
		myAccountLink.click();
		return new MyAccountPage(drv);
	}
	
	public boolean myAccountLinkDisplayed(){
		return myAccountLink.isDisplayed();
	}
	
	public boolean signOutLinkDisplayed(){
		return signOutLink.isDisplayed();
	}
	
	public SigninPage clickSignoutLink(){
		signOutLink.click();
		return new SigninPage(drv);
	}
}
