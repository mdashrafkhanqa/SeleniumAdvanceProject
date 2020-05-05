package pageController;

import base.ScriptBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginController {

    @FindBy(xpath = "//*[@id='header']//a[contains(text(),'Sign in')]")
    WebElement signInButton;

    public LoginController(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void signInTab(){
        signInButton.isDisplayed();
    }

}
