package com.github.serenity.steps.api.test;

import com.github.serenity.steps.api.AbstractApiSteps;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class BDDStyleMethod extends AbstractApiSteps {

    private static final String POSTS_API_PATH = "/posts";

    public static void SimpleGETPost(final String postId) {
        given().contentType(ContentType.JSON)
                .when().get(format("%s/%s", POSTS_API_PATH, postId))
                .then().body("author", is("Hrynko A"));
    }

    public static void PerformContainCollection(final String postId) {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(format("%s/", POSTS_API_PATH))
        .then().body("author", containsInAnyOrder("Hrynko A", "Hrynko A", null));
    }
}
