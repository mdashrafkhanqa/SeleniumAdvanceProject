package login;

import base.ScriptBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageController.LoginController;

public class LoginTest extends ScriptBase {
    LoginController loginController; //initialize LoginController class object

    @Test (priority = 1)
    public void verifySignInButton(){
        loginController = new LoginController(driver);  //class level variable
        loginController.signInTab();
    }

    @Test (priority = 2)
    public void verifyInvalidLogIn() throws InterruptedException {
        loginController = new LoginController(driver);  //class level variable
        loginController.invalidLogIn(driver,"There is 1 error");
    }

}
