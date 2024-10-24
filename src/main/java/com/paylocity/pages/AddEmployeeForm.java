package com.paylocity.pages;

import org.openqa.selenium.By;

import static utils.JavaScriptUtility.scrollToElementJS;

public class AddEmployeeForm extends BasePage{
    private By formCard = By.cssSelector("form[role='form']");
    public FormsPage gotToForms(){
       // scrollToElementJS(formCard);
        click(formCard);
        return new FormsPage();
    }
}