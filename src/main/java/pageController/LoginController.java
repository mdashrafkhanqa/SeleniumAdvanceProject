package pageController;

import base.ScriptBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginController {

    @FindBy(xpath = "//*[@id='header']//a[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(id = "email")
    WebElement userName;
    @FindBy(id = "passwd")
    WebElement userPassword;
    @FindBy(css = "#SubmitLogin > span")
    WebElement submitLogIn;
    @FindBy(xpath = "//p[contains(text(),'There is 1 error')]")
    WebElement invalidLoginError;

    public LoginController(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void signInTab(){
        signInButton.isDisplayed();
    }

    public void invalidLogIn(WebDriver driver, String message) throws InterruptedException {
        Thread.sleep(1000);
        signInButton.click();
        userName.sendKeys("abcde@gmail.com");
        userPassword.sendKeys("abcd1234");
        submitLogIn.click();
        //Assert.assertEquals(invalidLoginError,invalidLoginError);
        errorMessage(driver,message);
    }

    public void errorMessage(WebDriver driver, String message){
        driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed();
    }

}
