package com.paylocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class BenefitsDetailsPage extends BasePage{
    private final By addButton = By.id("add");
    private final By tableColumnHeaders = By.cssSelector("#employeesTable thead th");
    public boolean validateTableColumnHeaders(){
        List<String> expectedHeaders = Arrays.asList(
                "Id", "Last Name", "First Name", "Dependents",
                "Salary", "Gross Pay", "Benefits Cost", "Net Pay", "Actions"
        );
        List<String> actualHeaders = getTableColumnHeaders();
        return actualHeaders.equals(expectedHeaders);
    }
    public List<String> getTableColumnHeaders(){
        List<WebElement> headers = driver.findElements(tableColumnHeaders);
        return headers.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public boolean isAddEmployeeButtonDisplayed(){
        return find(addButton).isDisplayed();
    }
}
