package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScriptBase {

    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriver driver;
    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeTest(String browser, String environment){
        if (browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        if (environment.equalsIgnoreCase("dev")){
            driver.get("http://automationpractice_dev.com/index.php");
        }else if (environment.equalsIgnoreCase("qa")){
            driver.get("http://automationpractice_qa.com/index.php");
        }else if (environment.equalsIgnoreCase("")){
            driver.get("http://automationpractice.com/index.php");
        }

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
