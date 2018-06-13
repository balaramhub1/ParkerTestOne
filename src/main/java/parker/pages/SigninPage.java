package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class SigninPage extends TestBase{
	
	public SigninPage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Secure Sign In')]")
	WebElement secureSignInText;
	
	@FindBy(id="WC_AccountDisplay_FormInput_logonId_In_Logon_1")
	WebElement userId;
	
	@FindBy(id="WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")
	WebElement pass;

	@FindBy(id="WC_AccountDisplay_links_2")
	WebElement signInBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Create An Account')]")
	WebElement createAccountText;
	
	@FindBy(id="WC_AccountDisplay_links_3")
	WebElement createAccLink;
	
	public String signInPageTitle(){
		return drv.getTitle();
	}
	
	public boolean signInPageDisplayed(){
		return secureSignInText.isDisplayed();
	}
	
	public boolean createAccountDisplayed(){
		return createAccountText.isDisplayed();
	}
	
	public UserPage signIn(String un,String pa){
		userId.sendKeys(un);
		pass.sendKeys(pa);
		signInBtn.click();
		return new UserPage(drv);
	}
	
	public RegistrationPage createAccountLink(){
		createAccLink.click();
		return new RegistrationPage(drv);
	}
	
	
	
}
