package parker.homepage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import parker.base.TestBase;
import parker.pages.HomePage;
import parker.pages.ProductsPage;
import parker.pages.SigninPage;
import parker.pages.ValvesPage;
import parker.pages.WhereToBuyPage;
import parker.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	SigninPage signinpage;
	ValvesPage valvespage;
	ProductsPage productspage;
	WhereToBuyPage wheretobuy;
	TestUtil testutil;

	//@Parameters("browser")
	@BeforeMethod
	public void initTest(){
		initSetup();
		testutil=new TestUtil(drv);
		homepage=new HomePage(drv);	
		
	}
	
	@Test(priority=1)
	public void parkerPageTitleTest(){
		Assert.assertEquals(homepage.homePageTitle(), "Parker Engineering Your Success "
				+ "Motion Control Technology - Parker","Title mismatch found ");
	}
	
	@Test(priority=2)
	public void parkerLogoTest(){
		//testutil.TakePhoto();
		Assert.assertTrue(homepage.parkerLogoDisplayed());
	}
	
	@Test(priority=3)
	public void inqSectionDispTest(){
		Assert.assertTrue(homepage.inqSectionDisp());
	}
	
	@Test(priority=4)
	public void chatSectionDispTest(){
		Assert.assertFalse(homepage.chatSectionDisp());
	}
	
	@Test(priority=5)
	public void confSectionDispTest(){
		Assert.assertTrue(homepage.confSectionDisp());
	}
	
	@Test(priority=6)
	public void clikOnValvesTest(){
		valvespage=homepage.clikOnValves();
	}
	
	@Test(priority=7)
	public void clickOnSigninRegisterTest(){
		signinpage=homepage.clickOnSigninRegister();
	}
	
	@Test(priority=8)
	public void clickOnProductsLinkTest(){
		productspage=homepage.clickOnProductsLink();
	}
	
	@Test(priority=9)
	public void clickOnWhereToBuyLinkTest(){
		wheretobuy=homepage.clickOnWhereToBuyLink();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		/*if(ITestResult.FAILURE==result.getStatus()){
			testutil.TakePhoto(drv, result);
		}*/
			
		drv.quit();
	}
	
		
}
