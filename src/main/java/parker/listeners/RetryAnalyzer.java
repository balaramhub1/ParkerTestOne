package parker.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int maxRetry=3;
	public boolean retry(ITestResult result) {
		if(count<maxRetry){
			count++;
			return true;
		}
		return false;
	}

}
