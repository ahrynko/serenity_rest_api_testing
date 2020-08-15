package com.github.jbehave.scenarionsteps.api.test;

import com.github.serenity.steps.api.test.ApiTestSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class ApiTestScenario {

    @Steps
    private ApiTestSteps apiTestSteps;


    @Given("I perform 'GET' operation for new post, using API:")
    public void iPerformGETOperation(final ExamplesTable newPostInfo) {
        apiTestSteps.iPerformGETForThePostNumber("");
    }

    @When("I perform GET for the post number '1'")
    public void iPerformGETForThePostNumber() {
        apiTestSteps.iPerformGETForThePostNumber("getInfo");
    }


    @Then("I should see the author name as 'Hrynko A'")
    public void iShouldSeeAuthorNameAs(final String arg0) {

    }

    @Then("I should see the author names")
    public void iShouldSeeAuthorNames() {
        apiTestSteps.iShouldSeeAuthorNameAs("");
    }
}
