package parker.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import parker.base.TestBase;

public class ParkerTestListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		Object currentClass=result.getInstance();
		WebDriver dr=((TestBase)currentClass).drv;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dFormat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		
		String methodName=result.getName();
		
		if(result.isSuccess()){
			File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			
			try{
				String screenShotDir=new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenshot/";
				File destFile=new File((String)screenShotDir + methodName + "_"+dFormat.format(cal.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				
				
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}

	public void onTestFailure(ITestResult result) {
		Object currentClass=result.getInstance();
		WebDriver dr=((TestBase)currentClass).drv;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dFormat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		
		String methodName=result.getName();
		
		if(!result.isSuccess()){
			File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			
			try{
				String screenShotDir=new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenshot/";
				File destFile=new File((String)screenShotDir + methodName + "_"+dFormat.format(cal.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				
				
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
}
