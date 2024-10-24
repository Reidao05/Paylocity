package com.paylocity.test.benefitsdetails;

import com.paylocity.pages.BenefitsDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.paylocity.base.BaseTest;

public class BenefitsDashboardTest extends BaseTest {

    @Test
    public void testBenefitsDashboardTableColumnHeaderIsDisplayed(){
        BenefitsDetailsPage benefitsDetailsPage = loginPage.loginIntoApplication("TestUser474", "*WM&/Us/V$oa");
        Assert.assertTrue(benefitsDetailsPage.validateTableColumnHeaders(), "Table headers are not displayed correctly!");
        Assert.assertTrue(benefitsDetailsPage.isAddEmployeeButtonDisplayed());

    }
}
