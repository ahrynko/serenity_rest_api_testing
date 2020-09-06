package com.github.web_services.weltrade;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RestTemplate {

    private static final String SEARCH_ENDPOINT = "/api/v1";

    public RestTemplate() {
        RestAssured.baseURI = "http://dev.weltrade.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public List<Arrays> getAllPosts() {
        return Collections.singletonList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get(SEARCH_ENDPOINT).as(Arrays.class));  //GET   .asString() - получить String > Response
//                .as([].class));  // .as- (если распартсить)
    }
}
