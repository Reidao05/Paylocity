package com.paylocity.api;

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
    Integer dependants = response.jsonPath().get("dependants") != null ? response.jsonPath().getInt("dependants") : null;
    Integer salary = response.jsonPath().get("salary") != null ? response.jsonPath().getInt("salary") : null;
    Integer gross = response.jsonPath().get("gross") != null ? response.jsonPath().getInt("gross") : null;



    Assert.assertNotNull(id, "User ID  should not be null after successful creation! ");
    Assert.assertEquals(firstName, "Steven", "First name does not match!");
    Assert.assertEquals(lastName, "Davidson", "last name does not match!");
    Assert.assertEquals(dependants, 3, "Dependants value is incorrect");
    Assert.assertEquals(salary, 52000, "Salary value is incorrect");
    Assert.assertEquals(gross, 2000, "Gross pay value is incorrect");
    Assert.assertNotNull(dependants, "Dependants not be null");
    Assert.assertNotNull(salary, "Salary not be null");
    Assert.assertNotNull(gross, "Gross pay not be null");

    }
}
