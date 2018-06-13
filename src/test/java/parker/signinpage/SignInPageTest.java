package parker.signinpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import parker.base.TestBase;
import parker.pages.HomePage;
import parker.pages.RegistrationPage;
import parker.pages.SigninPage;
import parker.pages.UserPage;

public class SignInPageTest extends TestBase{
	
	HomePage homepage;
	SigninPage signinpage;
	UserPage userpage;
	RegistrationPage regpage;
	
	
	@BeforeMethod
	public void initTest(){
		initSetup();
		homepage=new HomePage(drv);
		signinpage=new SigninPage(drv);
		drv.get("https://ph.parker.com/in/en/Login?myAcctMain=1");
		
	}
	
	@Test(priority=1)
	public void signInPageTitleTest(){
		Assert.assertEquals(signinpage.signInPageTitle(), "Sign In", "Tile Mismatch in Signin Page");
	}
	
	@Test(priority=2)
	public void secureSignInDispTest(){
		Assert.assertTrue(signinpage.signInPageDisplayed(), "Secure Signin Section not displayed.");
	}
	
	@Test(priority=3)
	public void createAccountDispTest(){
		Assert.assertTrue(signinpage.createAccountDisplayed(), "Account Creation section not displayed");
	}
	
	@Test(priority=4)
	public void signinToParkerTest(){
		userpage=signinpage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(userpage.myAccountLinkDisplayed(), "Login Failure");
	}
	
	@Test(priority=5)
	public void createAccountLinkTest(){
		regpage=signinpage.createAccountLink();
		Assert.assertTrue(regpage.createAccSectionDisplayed(), "Not in Registration Page");
	}
	
	@AfterMethod
	public void tearDown(){
		drv.close();
	}

}
