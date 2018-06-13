package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}
	
	
	@FindBy(xpath="//h2[contains(text(),'Make an Inquiry')]")
	WebElement inquiry_section;
		
	@FindBy(xpath="//h2[contains(text(),'Online Chat')]")
	WebElement chat_section;
	
	@FindBy(xpath="//h2[contains(text(),'CAD Library')]")
	WebElement cad_lib_section;
	
	@FindBy(xpath="//h2[contains(text(),'eConfigurators and eSelectors')]")
	WebElement conf_sel_section;
	
	@FindBy(xpath="//a[@title='Sign In / Register']")
	WebElement signInRegisterLink;
	
	@FindBy(xpath="//a[@href='http://ph.parker.com/in/en/valves']")
	WebElement valvesLink;
	
	@FindBy(xpath="//a[@class='navbar-brand logo visible-lg']")
	WebElement parkerLogo;
	
	@FindBy(xpath="//a[@title='Products']")
	WebElement productsLink;
	
	@FindBy(xpath="//a[@title='Where to Buy']")
	WebElement toBuyLink;
	
	public String homePageTitle(){
		return drv.getTitle();
	}
	
	public boolean parkerLogoDisplayed(){
		System.out.println("Value of Parkerlogo is :" +parkerLogo);
		jlog.info("Checking availability of parker Logo");
		return parkerLogo.isDisplayed();
	}
	
	public boolean inqSectionDisp(){
		System.out.println("Value of inquiry section is :" +inquiry_section);
		jlog.info("Checking availability of Inquiry Section");
		return inquiry_section.isDisplayed();
	}
	
	public boolean chatSectionDisp(){
		jlog.info("Checking availability of chat section");
		return chat_section.isDisplayed();
	}
	
	public boolean cadLibSectionDisp(){
		return cad_lib_section.isDisplayed();
	}
	
	public boolean confSectionDisp(){
		return conf_sel_section.isDisplayed();
	}
	
	public SigninPage clickOnSigninRegister(){
		signInRegisterLink.click();
		System.out.println(signInRegisterLink +"is clicked");
		return new SigninPage(drv);
	}
	public ValvesPage clikOnValves(){
		valvesLink.click();
		return new ValvesPage(drv);
		
	}
	
	public ProductsPage clickOnProductsLink(){
		productsLink.click();
		return new ProductsPage(drv);
	}
	
	public WhereToBuyPage clickOnWhereToBuyLink(){
		toBuyLink.click();
		return new WhereToBuyPage(drv);
	}
	

}
