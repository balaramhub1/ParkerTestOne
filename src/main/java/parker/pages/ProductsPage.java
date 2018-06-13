package parker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parker.base.TestBase;

public class ProductsPage extends TestBase{

	public ProductsPage(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.drv=dr;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Products')]")
	WebElement productsLabel;
	
	@FindBy(xpath="//h3[@class='bg-h3-black']")
	WebElement productsFromParkerLabel;
	
	public boolean productsLabelDisp(){
		return productsLabel.isDisplayed();
	}
	
	public boolean productsFromParkerLabelDisp(){
		return productsFromParkerLabel.isDisplayed();
	}
}
