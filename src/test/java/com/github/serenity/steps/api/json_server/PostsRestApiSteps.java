package com.github.serenity.steps.api.json_server;

import com.github.api.dto.json_server.PostsDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class PostsRestApiSteps extends AbstractApiSteps {

    private static final String POSTS_API_PATH = "/posts";

    @Step
    public Response createNewPost(final PostsDTO postRequest) {
        return RestAssured.given()
                .contentType(ContentType.JSON)      //work with json
                .body(postRequest)        // автоматическое преобразование в json
                .post(POSTS_API_PATH);    //POST
    }

    @Step
    public void removePostById(final Integer postId) {
        RestAssured.delete(String.format("%s/%s", POSTS_API_PATH, postId));
    }

    @Step
    public List<PostsDTO> getAllPosts() {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get(POSTS_API_PATH)  //GET   .asString() - получить String > Response
                .as(PostsDTO[].class));  // .as- (если распартсить)
    }

    @Step
    public PostsDTO getPostById(final Integer postId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(String.format("%s/%s", POSTS_API_PATH, postId))   //GET
                .as(PostsDTO.class);
    }

    @Step
    public List<PostsDTO> getByQueryParams(final Map<String, String> params) {  //фильтр по параметрам
        return Arrays.asList(RestAssured.given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .get(POSTS_API_PATH)                //GET
                .as(PostsDTO[].class));
    }

    @Step
    public PostsDTO updatePostById(final PostsDTO newPostData, final Integer existingPostId) {
        return RestAssured.given()
                .body(newPostData)  //new Object at body
                .contentType(ContentType.JSON)
                .put(format("%s/%s", POSTS_API_PATH, existingPostId))   //PUT
                .as(PostsDTO.class);
    }

}
