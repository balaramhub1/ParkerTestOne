package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import parker.base.TestBase;
import parker.util.TestUtil;

public class WhereToBuyPage extends TestBase{

	public WhereToBuyPage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}
	
	@FindBy(xpath="//h3[contains(text(),'Where do you want to buy?')]")
	WebElement whereToBuyLabel;
	
	@FindBy(xpath="//h3[contains(text(),'Select a Product Category or Build a List')]")
	WebElement selectProductCategoryLabel;
	
	@FindBy(id="countrySelect")
	WebElement selectCountry;
	
	public boolean whereToBuyLabelDisp(){
		return whereToBuyLabel.isDisplayed();
	}
	
	public boolean selectProductCategoryLabelDisp(){
		TestUtil testutil=new TestUtil(drv);
		testutil.waitForElement(selectProductCategoryLabel);
		return selectProductCategoryLabel.isDisplayed();
	}
	
	public void selectCountryFromList(String country){
		Select sel=new Select(selectCountry);
		sel.selectByVisibleText(country);
	}
	
	
}
