package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScriptBase {

    public WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browser){
        if (browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        }
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
