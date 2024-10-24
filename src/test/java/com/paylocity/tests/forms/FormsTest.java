package com.paylocity.tests.forms;

import com.paylocity.base.BaseTest;
import com.paylocity.pages.BenefitsDetailsPage;
import com.paylocity.pages.FormsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    @Test
    public void testEnterEmployeeInformationIntoTheForm() {
        BenefitsDetailsPage benefitsDetailsPage = loginPage.loginIntoApplication("TestUser474", "*WM&/Us/V$oa");
        FormsPage formsPage = new FormsPage();
        formsPage.setDriver(driver);
        formsPage.enterEmployeeInformationIntoTheForm("Mike", "JonesII", "5");
        Assert.assertTrue(formsPage.isAddEmployeeButtonDisplayed());
    }
}