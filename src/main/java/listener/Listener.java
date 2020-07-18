package listener;

import base.ScriptBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        //Object testClass = iTestResult.getInstance();
        //WebDriver webDriver = ((ScriptBase)testClass).getDriver();
        //String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
        String methodName = iTestResult.getName();
        if (iTestResult.getStatus()==ITestResult.FAILURE){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/failureScreenshots";
                File destFile = new File((String)reportDirectory+"/"+methodName+"_"+format.format(calendar.getTime())+".png");
                Utils.copyFile(srcFile,destFile);
                Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <image src='"+destFile.getAbsolutePath()+"'height='100' width'100'/> </a>");
            } catch (Exception e){
        }
    }
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
