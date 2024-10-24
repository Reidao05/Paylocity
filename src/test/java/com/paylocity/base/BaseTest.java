package com.paylocity.base;

import com.paylocity.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Constants;

import java.time.Duration;

import static utils.Utility.setUtilityDriver;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected UpdateEmployeePage updateEmployeePage;
    protected FormsPage formsPage;
    protected BenefitsDetailsPage benefitsDetailsPage;
    protected AddEmployeeForm addEmployeeForm;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @BeforeMethod
        public void loadApplication(){
        driver.get(Constants.urlPaylocity);
        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
        loginPage.setDriver(driver);

        addEmployeeForm = new AddEmployeeForm();
        addEmployeeForm.setDriver(driver);

        benefitsDetailsPage = new BenefitsDetailsPage();
        benefitsDetailsPage.setDriver(driver);

        formsPage = new FormsPage();
        formsPage.setDriver(driver);

        updateEmployeePage = new UpdateEmployeePage();
        updateEmployeePage.setDriver(driver);

        
    }
    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
