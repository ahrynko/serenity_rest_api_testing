package com.github.serenity.steps.api.weltrade;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.Arrays;
import java.util.List;

public class WeltradeApiSteps extends ScenarioSteps {

    private static final String WELTRADE_API_PATH = "/api/v1";

    @Step
    public List<String> getAllPosts() {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get(WELTRADE_API_PATH)  //GET   .asString() - получить String > Response
                .as(String[].class));  // .as- (если распартсить)
    }

}
