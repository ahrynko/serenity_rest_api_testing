package com.github.jbehave.scenarionsteps.api.weltrade;

import com.github.web_services.weltrade.RestTemplate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

import java.util.Arrays;
import java.util.List;

public class WeltradeApiScenario {

//    @Steps
//    private WeltradeApiSteps weltradeApiSteps;

    @Given("user retrieved all 'POST' to /partners/conditions/")
    public void retrievedAllPost() {

        RestTemplate restTemplate = new RestTemplate();

        final List<Arrays> getListPosts = restTemplate.getAllPosts();
    }

}
