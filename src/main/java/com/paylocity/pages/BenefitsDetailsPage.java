package com.paylocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class BenefitsDetailsPage extends BasePage{
    private final By addButton = By.id("add");
    //Find an ID from hte table
    public WebElement getRowById(String employeeId) {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeesTable']/tbody/tr"));
        for (WebElement row : rows) {
            String rowId = row.findElement(By.xpath("./td[1]")).getText();
            if (rowId.equals(employeeId)) {
                return row;
            }
        }
        return null; // return null if no matching row is found
    }
    //Click delete button
    public void clickDeleteButtonForRow(WebElement row) {
        row.findElement(By.xpath("./td[last()]/i[@class='fas fa-times']")).click();
    }
    //check after the delete method if row exist
    public boolean isRowPresent(String employeeId) {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeesTable']/tbody/tr"));
        for (WebElement row : rows) {
            String rowId = row.findElement(By.xpath("./td[1]")).getText();
            if (rowId.equals(employeeId)) {
                return true; // Row is still there
            }
        }
        return false; // Row is not there
    }
    public WebElement getDeleteModal() {
        return driver.findElement(By.xpath("//*[@id='deleteModal']/div/div"));
    }
    // click Delete button
    public void confirmDelete() {
        WebElement deleteButton = driver.findElement(By.id("deleteEmployee"));
        deleteButton.click();
    }
    //Cancel delete button
    public void cancelDelete() {
        WebElement cancelButton = driver.findElement(By.xpath("//button[@data-dismiss='modal']"));
        cancelButton.click();
    }
    //check for the display popup
    public boolean isDeleteModalDisplayed() {
        return getDeleteModal().isDisplayed();
    }
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

    public double getBenefitsCostFromUI(String employeeId) {
        WebElement row = getRowById(employeeId);
        return Double.parseDouble(row.findElement(By.xpath("./td[7]")).getText());
    }

    public double getNetPayFromUI(String employeeId) {
        WebElement row = getRowById(employeeId);
        return Double.parseDouble(row.findElement(By.xpath("./td[8]")).getText());
    }

}