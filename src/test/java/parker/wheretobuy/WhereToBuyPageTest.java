package parker.wheretobuy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import parker.base.TestBase;
import parker.pages.HomePage;
import parker.pages.WhereToBuyPage;

public class WhereToBuyPageTest extends TestBase{
	
	HomePage homepage;
	WhereToBuyPage wheretobuy;
	
	@BeforeMethod
	public void initTest(){
		initSetup();
		homepage=new HomePage(drv);
		wheretobuy=new WhereToBuyPage(drv);
		homepage.clickOnWhereToBuyLink();
	}
	
	@Test(priority=1)
	public void whereToBuyLabelDispTest(){
		Assert.assertTrue(wheretobuy.whereToBuyLabelDisp(), "Where to Buy Label Not Displayed.");
	}
	
	@Test(priority=2)
	public void selectProductCategoryLabelDispTest(){
		Assert.assertTrue(wheretobuy.selectProductCategoryLabelDisp(), "Product Category Label Not Displayed");
	}
	
	@Test(priority=3)
	public void selectCountryFromListTest(){
		wheretobuy.selectCountryFromList("Indonesia");
		
	}
	
	@AfterMethod
	public void tearDown(){
		drv.close();
	}
	

}
