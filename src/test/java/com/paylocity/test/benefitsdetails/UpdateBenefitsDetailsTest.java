package com.paylocity.test.benefitsdetails;

import com.paylocity.base.BaseTest;
import com.paylocity.pages.BenefitsDetailsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EmployeeBenefitsCalculator;

public class UpdateBenefitsDetailsTest extends BaseTest {

    @Test
    public void testUpdateEmployeeDetails(){
        BenefitsDetailsPage benefitsDetailsPage = loginPage.loginIntoApplication("TestUser474", "*WM&/Us/V$oa");
        String employeeIdToUpdate = "7d6c16d0-7b0b-4d19-ae69-46cbb209d7b3";
        WebElement row = benefitsDetailsPage.getRowById(employeeIdToUpdate);

        if (row == null) {
            System.out.println("Row with ID " + employeeIdToUpdate + " not found. Test will be skipped.");
            return; // Exit if row not found
        }
        updateEmployeePage.clickEditIcon();;
        Assert.assertTrue(updateEmployeePage.isUpdateModalDisplayed(), "Update popup is not displayed");
        updateEmployeePage.setFirstName("Mike");
        updateEmployeePage.setLastName("Jones");
        int newDependents = Integer.parseInt("1");
        updateEmployeePage.setDependents(String.valueOf(newDependents));

        double expectedBenefits = EmployeeBenefitsCalculator.calculateBenefitsCost(newDependents);
        double expectedNetPay = EmployeeBenefitsCalculator.calculateNetPay(newDependents);

        updateEmployeePage.clickUpdateButton();
        double actualBenefitsCost = benefitsDetailsPage.getBenefitsCostFromUI(employeeIdToUpdate);
        double actualNetPay = benefitsDetailsPage.getNetPayFromUI(employeeIdToUpdate);

        Assert.assertEquals(actualBenefitsCost, expectedBenefits, "Benefits cost not updated correctly.");
        Assert.assertEquals(actualNetPay, expectedNetPay, "Net pay not updated correctly.");
    }
}