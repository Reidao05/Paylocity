package com.paylocity.api;

import com.paylocity.api.PaylocityApiRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.io.File;

import static utils.Constants.*;

public class PostAddEmployeeRequestTest {
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
    public void testAPostRequestWithJsonFile(){
        File jsonFile = new File("src/main/resources/addEmployee.json");
        Response response = apiRequest.sendAPostRequest("/employees",jsonFile, username, password, authToken).then().log().all().extract().response();
        //Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is not returned!");
        String id = response.jsonPath().getString("id");
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");
        String dependants = response.jsonPath().getString("dependants");

        System.out.println("Employee Id " + id);
        System.out.println("First Name " + firstName);
        System.out.println("Last Name " + lastName);
        System.out.println("Dependants " + dependants);

        Assert.assertNotNull(id, "User ID  should not be null after successful creation! ");
        Assert.assertEquals(firstName, "Steven", "First name does not match!");
        Assert.assertEquals(lastName, "Davidson", "last name does not match!");
        Assert.assertNotNull(dependants, "Dependants ");
    }
}
