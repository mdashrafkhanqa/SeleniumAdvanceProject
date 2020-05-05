package login;

import base.ScriptBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageController.LoginController;

public class LoginTest extends ScriptBase {
    LoginController loginController;

    @BeforeTest
    public void init(){
        beforeTest();
    }

    @Test
    public void verifySignInButton(){
        loginController = new LoginController(driver);  //class level variable
        loginController.signInTab();
    }
}
