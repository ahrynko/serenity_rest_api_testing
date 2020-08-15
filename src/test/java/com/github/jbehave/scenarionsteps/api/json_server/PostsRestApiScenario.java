package com.github.jbehave.scenarionsteps.api.json_server;

import com.github.serenity.steps.api.json_server.PostsRestApiSteps;
import com.github.logging.Logger;
import com.github.api.dto.json_server.PostsDTO;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class PostsRestApiScenario {

    @Steps
    private PostsRestApiSteps restApiGetPostSteps;

    private static final String CREATED_POST_KEY = "created_post_key";    //POST (response)ответ
    private static final String EXPECTED_POST_DATA_KEY = "expected_post_data_key";   //POST (current table PostsDTO object)
    private static final String UPDATED_POST_DATA_KEY = "updated_post_data_key";   //PUT (update)
    private static final Integer EXPECTED_POST_ID = 1;  //DELETE

    @Given("user creates new 'POST', using API: $postData")
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

    @When("user update existing post, using following data:  $newPostData")
    public void updateExistingPost(final ExamplesTable requestBody) {

        //Парсим нашу таблицу (из стори файла) в Object (который будет использоваться в реквест бади)
        final PostsDTO body = requestBody.getRowsAs(PostsDTO.class).get(0);

        //Получаю из сессии сохраненный респонс (после создания нового Post object)
        final Response createdPost = Serenity.sessionVariableCalled(CREATED_POST_KEY);

        //Достаю из респонса id созданного Post Object
        final Integer createdPostId = createdPost.jsonPath().get("id");

        //Выполняем PUT реквест по айдишке (* createdPostId *) и с использованием реквест бади (* body *)
        final PostsDTO updatedPost = restApiGetPostSteps.updatePostById(body, createdPostId);

        //Положили в сессию Serenity проапдейченый Post Object (для дальнейшей проверки в @Then)
        Serenity.setSessionVariable(UPDATED_POST_DATA_KEY).to(updatedPost);
    }

    @Then("following post should be updated")
    public void isCreatedPostUpdatedByNewData() {

        //Получаем из Serenity session Post Object, который мы обновили и получили в @When (PUT)
        final PostsDTO expectedPostData = Serenity.sessionVariableCalled(UPDATED_POST_DATA_KEY);

        //Отправили GET request, получили респонс
        final PostsDTO actualPostData = restApiGetPostSteps.getPostById(expectedPostData.getId());

        //Сравили два Post Objects (после PUT, после GET)
        ReflectionAssert.assertReflectionEquals("There is incorrect 'updated' Post!",
                expectedPostData, actualPostData);
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

}
