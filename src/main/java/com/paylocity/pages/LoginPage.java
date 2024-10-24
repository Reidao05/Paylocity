package com.paylocity.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private final By usernameField = By.id("Username");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.className("btn-primary");
    private final By errorMessage = By.cssSelector("div.text-danger.validation-summary-errors");
    public void setUsername(String username){
        set(usernameField, username);
    }
    public void setPassword(String password){
        set(passwordField, password);
    }
    public BenefitsDetailsPage clickingLoginButton(){
        click(loginButton);
        return new BenefitsDetailsPage();
    }
    public BenefitsDetailsPage loginIntoApplication(String username, String password){
        waitForVisibility(usernameField, 10);
        setUsername(username);
        setPassword(password);
        return clickingLoginButton();
    }
    public String getErrorMessage(){
        return find(errorMessage).getText();
    }



}
