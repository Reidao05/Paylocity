package com.paylocity.pages;

import org.openqa.selenium.By;

public class FormsPage extends AddEmployeeForm{

    private final By employeeFirstNameField = By.id("firstName");
    private final By employeeLastNameField = By.id("lastName");
    private final By employeeCloseFormButton = By.cssSelector("button.close");
    private final By employeeDependentsField = By.id("dependants");
    public void setEmployeeFirstName(String firstname){
        set(employeeFirstNameField, firstname);
    }
    public void setEmployeeLastName(String lastname){
        set(employeeLastNameField, lastname);
    }
    public void setEmployeeDependents(String dependents){
        set(employeeDependentsField, dependents);
    }

 /**   public BenefitsDetailsPage enterEmployeeInformationIntoTheForm(String firstname, String lastname, String dependents){
        setEmployeeFirstName(firstname);
        setEmployeeLastName(lastname);
        setEmployeeDependents(dependents);
        return ();
    }**/
}
