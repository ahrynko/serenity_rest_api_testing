package com.github.jbehave.scenarionsteps.api;

import com.github.serenity.steps.api.PostsRestApiSteps;
import com.github.logging.Logger;
import com.github.api.dto.PostsDTO;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class PostsRestApiScenario {

    @Steps
    private PostsRestApiSteps restApiGetPostSteps;

    private static final String CREATED_POST_KEY = "created_post_key";    //POST (response)ответ
    private static final String EXPECTED_POST_DATA_KEY = "expected_post_data_key";   //POST (current table PostsDTO object)
    private static final Integer EXPECTED_POST_ID = 1;  //DELETE

    @Given("user creates new 'POST' using API: $postData")
    public void createNewPost(final ExamplesTable newPostInfo) {
        final PostsDTO newPostsData = newPostInfo.getRowsAs(PostsDTO.class).get(0);
        final Response newPostResponse = restApiGetPostSteps.createNewPost(newPostsData);

        Serenity.setSessionVariable(EXPECTED_POST_DATA_KEY).to(newPostsData); // положили в сессию данные табл. PostsDTO object
        Serenity.setSessionVariable(CREATED_POST_KEY).to(newPostResponse);  // положили (response)ответ в сессию
    }

    @Given("user removes id users to API Resources")
    public void deleteApiResources() {

        Logger.out.debug("! ----------- Removing Rest API Created Resources ---------------- !");

        restApiGetPostSteps.removePostById(EXPECTED_POST_ID);

        Logger.out.debug("! ----------- Removing Rest API Created Resources Done ----------- !");
    }




    @Given("I perform 'GET' operation for new post, using API:")
    public void iPerformGETOperation(final ExamplesTable newPostInfo) {
        restApiGetPostSteps.iPerformGETForThePostNumber("");
    }

    @When("I perform GET for the post number '1'")
    public void iPerformGETForThePostNumber() {
        restApiGetPostSteps.iPerformGETForThePostNumber("getInfo");
    }

    @Then("new 'POST' should be created to posts")
    public void isNewPostCreated() {

        final Response createdPostResponse = Serenity.sessionVariableCalled(CREATED_POST_KEY); // достали из сессии (response)ответ

        final PostsDTO actualPost = createdPostResponse.as(PostsDTO.class); // распарсить json (response)ответ в объект PostsDTO
        final PostsDTO expectedPost = Serenity.sessionVariableCalled(EXPECTED_POST_DATA_KEY); // достали из сессии табл. PostsDTO object по полям

        final SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(createdPostResponse.getStatusCode())  //проверка ответа- 201
                .as("Incorrect status code!")
                .isEqualTo(201);

        softAssertions.assertThat(actualPost.getTitle())     //сравнение по полям
                .as("There is incorrect title!")
                .isEqualTo(expectedPost.getTitle());

        softAssertions.assertThat(actualPost.getAuthor())    //сравнение по полям
                .as("There is incorrect author!")
                .isEqualTo(expectedPost.getAuthor());

        softAssertions.assertThat(actualPost.getAge())      //сравнение по полям
                .as("There is incorrect age!")
                .isEqualTo(expectedPost.getAge());

        softAssertions.assertAll();
    }


    @Then("I should see the author name as 'Hrynko A'")
    public void iShouldSeeAuthorNameAs(final String arg0) {

    }

    @Then("I should see the author names")
    public void iShouldSeeAuthorNames() {
        restApiGetPostSteps.iShouldSeeAuthorNameAs("");
    }
}
