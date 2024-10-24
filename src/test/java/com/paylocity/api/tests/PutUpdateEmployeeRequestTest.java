package com.paylocity.api.tests;

import com.paylocity.api.PaylocityApiRequest;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static utils.Constants.*;

public class PutUpdateEmployeeRequestTest {
    private PaylocityApiRequest apiRequest;
    private String authToken;
    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        apiRequest = new PaylocityApiRequest();
        authToken = basicAuth;
        username = userName;
        password = passWord;
    }

    @Test
    public void  testAUpdateEmployeeRequestWithJsonFile ()    {
    File jsonFile = new File("src/main/resources/UpdateEmployee.json");
    Response response = apiRequest.sendAPutRequest("employees", jsonFile, username, password, authToken).then().log().all().extract().response();
    assertEquals(response.getStatusCode(), 200, "Expected status code is not returned!");
    String id = response.jsonPath().getString("id");
    String firstName = response.jsonPath().getString("firstName");
    String lastName = response.jsonPath().getString("lastName");
    String dependants = response.jsonPath().getString("dependants");
    String salary = response.jsonPath().getString("Salary");
    String gross = response.jsonPath().getString("gross");

    System.out.println("Employee Id " + id);
    System.out.println("First Name " + firstName);
    System.out.println("Last Name " + lastName);
    System.out.println("Dependants " + dependants);
    System.out.println("salary " + salary);
    System.out.println("gross " + gross);

    Assert.assertNotNull(id, "User ID  should not be null after successful creation! ");
    Assert.assertEquals(firstName, "1234", "First name does not match!");
    Assert.assertEquals(lastName, "Smith", "last name does not match!");
    Assert.assertNotNull(dependants, "Dependants ");
    Assert.assertNotNull(salary, "0");
    Assert.assertNotNull(gross, "0");

    }
}
