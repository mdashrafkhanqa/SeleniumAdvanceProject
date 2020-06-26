package listener;

import base.ScriptBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends ScriptBase implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in on Test ---> "+getTestMethodName(iTestResult)+" (Start)");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in on Test ---> "+getTestMethodName(iTestResult)+" (Succeed)");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in on Test ---> "+getTestMethodName(iTestResult)+" (Failed)");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in on Test ---> "+getTestMethodName(iTestResult)+" (Skipped)");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onTestFailedWithTimeout(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in on Test ---> "+iTestContext.getName()+" (Start)");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in on Test ---> "+iTestContext.getName()+" (Finish)");
    }
}
