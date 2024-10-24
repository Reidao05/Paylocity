package com.paylocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateEmployeePage {
    //First Name
    private By firstNameField = By.id("firstName");
    //Last Name
    private By lastNameField = By.id("lastName");
    // Dependents
    private By dependentsField = By.id("dependants");
    //Update
    private By updateButton = By.id("updateEmployee");
    private  By editIcon = By.xpath("//i[@class='fas fa-edit']");

    // Method to set the First Name
    public void setFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameField);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
      public void setLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }
    public void setDependents(String dependents) {
        WebElement dependentsElement = driver.findElement(dependentsField);
        dependentsElement.clear();
        dependentsElement.sendKeys(dependents);
    }
    public void clickUpdateButton() {
        WebElement updateButtonElement = driver.findElement(updateButton);
        updateButtonElement.click();
    }
    public void clickEditIcon(){
        WebElement editIconElement = driver.findElement(editIcon);
        editIconElement.click();
    }
    public boolean isUpdateModalDisplayed() {
        return driver.findElement(By.className("modal-content")).isDisplayed();
    }
    public static WebDriver driver;
    public void setDriver(WebDriver driver){
        UpdateEmployeePage.driver = driver;
    }


}
