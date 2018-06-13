package parker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import parker.base.TestBase;

public class TestUtil extends TestBase{
	
	
	// All classes can consume the below static variables.
	
		public static long PAGE_LOAD_TIMEOUT=20;
		public static long IMPL_WAIT=10;
		
		static Workbook book;
		static Sheet sheet;
		
		public static String TESTDATA_SHEET_PATH="";
		
		WebDriverWait wa;
		
		public TestUtil(WebDriver dr){
			this.drv=dr;
		}
		
		/*public void switchToFrame(){
			drv.switchTo().frame("panel");
		}*/
		
		public WebElement waitForElement(WebElement el){
			wa=new WebDriverWait(drv,2000);
			el=wa.until(ExpectedConditions.visibilityOf(el));
			return el;
		}
		
		public static Object [][] getTestData(String sheetName){
			XSSFWorkbook wb=null;
			XSSFSheet sh=null;
			FileInputStream fis=null;
			
			try{
			fis = new FileInputStream("D:\\Selenimum Training\\Selenium Framework 3\\CRM_TestData.xlsx");
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			
			try{
				wb=new XSSFWorkbook(fis);
			}catch(IOException e){
				e.printStackTrace();
			}
			
			sh=wb.getSheet(sheetName);
			Object [][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
			for(int i=0;i<sh.getLastRowNum();i++){
				
				for(int j=0;j<sh.getRow(0).getLastCellNum();j++){
					//Row row=sh.getRow(i+1);
					//System.out.println(row.getCell(j));
					data[i][j]=sh.getRow(i+1).getCell(j).toString();
					
				}
			}
			
			return data;
		}
		
		public void TakePhoto(WebDriver drv,ITestResult result){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dFormat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
			String testMethodName=result.getName();
			File srcFile=((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
			
			if(!result.isSuccess()){
				
				try{
					String screenShotDir=new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenshot/";
					File destFile=new File((String)screenShotDir +testMethodName+ "_"+dFormat.format(cal.getTime())+".png");
					FileUtils.copyFile(srcFile, destFile);
					
					
				}catch (IOException e){
					e.printStackTrace();
				}
				
			}
		}

}
