package com.github.web_services.weltrade.quotes;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class RestTemplate {

    private static final String SEARCH_ENDPOINT = "/export/quotes.json";

    public RestTemplate() {
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        RestAssured.baseURI = "https://quotes.weltrade.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public String retrieveQuotesFromApi() {

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("callback", "quotes")
                .get(SEARCH_ENDPOINT)
                .asString();
    }
}