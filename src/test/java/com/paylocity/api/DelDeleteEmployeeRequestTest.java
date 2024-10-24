package com.paylocity.api;

import com.paylocity.api.PaylocityApiRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import static utils.Constants.*;

public class DelDeleteEmployeeRequestTest {
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
    public void testADeleteEmployeeRequest() {

        String employeeId = "33715040-3ace-44d7-bea3-72a2b11ff6f4";
        Response response = apiRequest.sendADelRequest("/employees", employeeId, username, password, authToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 status!");
    }
}
