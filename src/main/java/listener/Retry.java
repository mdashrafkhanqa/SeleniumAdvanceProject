package listener;

import org.testng.ITestResult;

public class Retry {
    private int count = 0;
    private static int maxTry = 1;

    public boolean retry(ITestResult iTestResult){
        if(iTestResult.isSuccess()){
            if(count<maxTry){
                count++;
                return true;
        }
        } else {
           iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
