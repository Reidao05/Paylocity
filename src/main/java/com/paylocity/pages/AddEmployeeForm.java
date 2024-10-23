package com.paylocity.pages;

import org.openqa.selenium.By;

public class AddEmployeeForm extends BasePage{
    private By formCard = By.cssSelector("form[role='form']");

    public FormsPage gotToForms(){
        click(formCard);
        return new FormsPage();
    }

}
