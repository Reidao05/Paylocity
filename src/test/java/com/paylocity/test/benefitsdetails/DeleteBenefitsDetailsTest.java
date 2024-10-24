package com.paylocity.test.benefitsdetails;

import com.paylocity.base.BaseTest;
import com.paylocity.pages.BenefitsDetailsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBenefitsDetailsTest extends BaseTest {

    @Test
    public void testDeleteEmployeeById(){
        BenefitsDetailsPage benefitsDetailsPage = loginPage.loginIntoApplication("TestUser474", "*WM&/Us/V$oa");

        String employeeIdToDelete = "aee4a8d5-1dae-47d3-9c1a-eb17d11e1581";
        WebElement row = benefitsDetailsPage.getRowById(employeeIdToDelete);
       // Check the row if found
        if (row == null) {
            System.out.println("Row with ID " + employeeIdToDelete + " not found. Test will be skipped.");
            return; // Exit if row is not found
        }
        //Click Delete
        benefitsDetailsPage.clickDeleteButtonForRow(row);
        //Verify popup is there
        Assert.assertTrue(benefitsDetailsPage.isDeleteModalDisplayed(), "PopUp modal is not displaying");
        //click the delete button on the popup modal
        benefitsDetailsPage.confirmDelete();
        //Verify the is gone
        boolean isRowPresent = benefitsDetailsPage.isRowPresent(employeeIdToDelete);
        Assert.assertTrue(isRowPresent, "Row with Id "+ employeeIdToDelete + " not deleted");

    }
}