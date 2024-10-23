package paylocity.com.tests.login;

import org.testng.annotations.Test;
import org.testng.Assert;
import paylocity.com.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("TestUser474");
        loginPage.setPassword("*WM&/Us/V$ob");
        loginPage.clickingLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("The specified username or password is incorrect."));
    }
}