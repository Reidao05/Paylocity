package paylocity.com.base;

import com.paylocity.pages.AddEmployeeForm;
import com.paylocity.pages.BasePage;
import com.paylocity.pages.LoginPage;
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
    protected AddEmployeeForm addEmployeeForm;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
        public void loadApplication(){
        driver.get(Constants.urlPaylocity);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        basePage = new BasePage();
        basePage.setDriver(driver);

        setUtilityDriver();
        loginPage = new LoginPage();
        loginPage.setDriver(driver);

        addEmployeeForm = new AddEmployeeForm();
        addEmployeeForm.setDriver(driver);
    }
    @AfterClass
    public void tearDown(){
       //driver.quit();
    }
}
