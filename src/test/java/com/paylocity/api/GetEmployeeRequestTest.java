package com.paylocity.api;

import com.paylocity.api.PaylocityApiRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import static org.testng.Assert.assertEquals;
import static utils.Constants.*;

public class GetEmployeeRequestTest {
    private PaylocityApiRequest apiRequest;
    private String authToken;
    private String username;
    private String password;

    @BeforeClass
    public void setUp(){
        apiRequest = new PaylocityApiRequest();
        authToken = basicAuth;
        username = userName;
        password = passWord;
    }
    @Test
    public void testGetEmployeeRequest(){
        String employeeOneId ="7d6c16d0-7b0b-4d19-ae69-46cbb209d7b3";
        Response response = apiRequest.sendAGetOneEmployeeRequest("/employees", employeeOneId,username, password, authToken);
        assertEquals(response.getStatusCode(), 200, "Expected status code is not returned!");
        assertEquals(response.getStatusCode(), 200, "Expected status code is not returned!");
        String id = response.jsonPath().getString("id");
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");
        String dependants = response.jsonPath().getString("dependants");
        String salary = response.jsonPath().getString("Salary");
        String gross = response.jsonPath().getString("gross");

        Assert.assertNotNull(id, "User ID  should not be null after successful creation! ");
        Assert.assertEquals(firstName, "Mike", "First name does not match!");
        Assert.assertEquals(lastName, "Jones", "last name does not match!");
        Assert.assertNotNull(dependants, "Dependants ");
        Assert.assertNotEquals(salary, "0");
        Assert.assertNotNull(gross, "0");

    }
}
