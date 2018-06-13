package parker.productspage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import parker.base.TestBase;
import parker.pages.HomePage;
import parker.pages.ProductsPage;

public class ProductsPageTest extends TestBase{
	
	HomePage homepage;
	ProductsPage productspage;
	
	@BeforeMethod
	public void initTest(){
		initSetup();
		homepage=new HomePage(drv);
		productspage=new ProductsPage(drv);
		homepage.clickOnProductsLink();
	}
	
	@Test(priority=1)
	public void productsLabelDispTest(){
		Assert.assertTrue(productspage.productsLabelDisp(), "Products Label not Displayed");
	}
	
	@Test(priority=2)
	public void productsFromParkerLabelDispTest(){
		Assert.assertTrue(productspage.productsFromParkerLabelDisp(), "Products From Parker Label is Not Displayed");
	}
	
	@AfterMethod
	public void tearDown(){
		drv.close();
	}
	

}
