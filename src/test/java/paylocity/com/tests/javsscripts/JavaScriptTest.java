package paylocity.com.tests.javsscripts;

import com.paylocity.pages.BenefitsDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import paylocity.com.base.BaseTest;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollingToElement(){
        BenefitsDetailsPage benefitsDetailsPage = loginPage.loginIntoApplication("TestUser474", "*WM&/Us/V$oa");
        Assert.assertTrue(benefitsDetailsPage.validateTableColumnHeaders(), "Table headers are not displayed correctly!");
        Assert.assertTrue(benefitsDetailsPage.isAddEmployeeButtonDisplayed());
        loginPage.clickingLoginButton();

        addEmployeeForm.gotToForms();
    }


}
