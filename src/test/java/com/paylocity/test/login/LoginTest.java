package com.paylocity.test.login;

import com.paylocity.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("TestUser474");
        loginPage.setPassword("*WM&/Us/V$ob");
        loginPage.clickingLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("The specified username or password is incorrect."));
    }
    @Test
    public void testLoginWithAValidId(){
        loginPage.setUsername("TestUser474");
        loginPage.setPassword("*WM&/Us/V$oa");
        loginPage.clickingLoginButton();
        loginPage.clickingLogoutButton();
        System.out.println("we login ");

    }
}