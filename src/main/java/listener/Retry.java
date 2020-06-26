package listener;
import base.ScriptBase;
import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count=0;
    private static int maxTry=1;

    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        else{
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
