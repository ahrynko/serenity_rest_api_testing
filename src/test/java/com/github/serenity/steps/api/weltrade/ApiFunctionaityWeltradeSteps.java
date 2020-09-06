package com.github.serenity.steps.api.weltrade;

import com.github.common.data.EnvironmentProperties;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class ApiFunctionaityWeltradeSteps {

    private static final String SEARCH_ENDPOINT = "/api/v1/";

    public ApiFunctionaityWeltradeSteps() {
        RestAssured.baseURI = EnvironmentProperties.WELTRADE_BASE_URL.readProperty();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); //logging to concole
    }

    public String getCalcProfitInfoFromApi() {

        return RestAssured.given()
                .contentType(ContentType.JSON)      //work with json
                .body("[{\"action\":\"partner.getCalcProfitInfo\",\"data\":[]}]")
                .post(SEARCH_ENDPOINT).asString();
    }
}

