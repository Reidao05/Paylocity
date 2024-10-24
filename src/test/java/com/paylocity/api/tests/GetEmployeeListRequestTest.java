package com.paylocity.api.tests;

import com.paylocity.api.PaylocityApiRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import static utils.Constants.*;

public class GetEmployeeListRequestTest {

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
    public void testAGetEmployeeListRequest(){

        Response response = apiRequest.sendAGetEmployeeListRequest("/employees", username, password, authToken).then().log().all().extract().response();;
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 status!");
        String id = response.jsonPath().getString("id");
        String dependants = response.jsonPath().getString("dependants");
        String salary = response.jsonPath().getString("Salary");
        String gross = response.jsonPath().getString("gross");

        Assert.assertNotNull(id, "User ID  should not be null after successful creation! ");
        Assert.assertNotNull(dependants, "Dependants ");
        Assert.assertNotNull(salary, "0");
        Assert.assertNotNull(gross, "0");
    }
}
