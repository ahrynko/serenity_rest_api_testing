package com.github.serenity.steps.api.test;

import com.github.serenity.steps.api.AbstractApiSteps;
import net.thucydides.core.annotations.Step;

public class ApiTestSteps extends AbstractApiSteps {

    @Step
    public void iPerformGETForThePostNumber(final String postId) {
        BDDStyleMethod.SimpleGETPost(postId);
    }

    @Step
    public void iShouldSeeAuthorNameAs(final String arg0) {
        BDDStyleMethod.PerformContainCollection(arg0);
    }
}
