package com.paylocity.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static utils.Constants.uriApiPaylocity;

public class PaylocityApiRequest {
    private static final String base_uri = uriApiPaylocity;
    public PaylocityApiRequest(){
        RestAssured.baseURI = base_uri;
    }

    public Response sendAPostRequest(String endpoint,File jsonFile, String username, String password,  String authToken){
        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username,password).header("Authorization","Bearer" + authToken).contentType("application/json; charset=utf-8").body(jsonFile);
        return request.post(endpoint);
    }

    public Response sendAGetEmployeeListRequest(String endpoint, String username, String password,String authToken){
        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password).header("Authorization","Bearer" + authToken);
        return request.get(endpoint);
    }
    public Response sendAGetOneEmployeeRequest(String endpoint, String employeeOneId,String username, String password,String authToken){
        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password).header("Authorization","Bearer" + authToken);
        return request.get(endpoint + "/" + employeeOneId).then().log().all().extract().response();
    }
    public Response sendAPutRequest(String endpoint, File jsonFile, String username, String password,String authToken){
        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password).header("Authorization","Bearer" + authToken).contentType("application/json; charset=utf-8").body(jsonFile);
        return request.put(endpoint);
    }
    public Response sendADelRequest(String endpoint, String employeeId, String username, String password,String authToken){
        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password).header("Authorization","Bearer" + authToken).contentType("application/json");
        return request.delete(endpoint + "/" + employeeId).then().log().all().extract().response();
    }

}
