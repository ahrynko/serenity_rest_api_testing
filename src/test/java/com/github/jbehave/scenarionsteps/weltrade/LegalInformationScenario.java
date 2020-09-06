package com.github.jbehave.scenarionsteps.weltrade;

import com.github.page_object.model.weltrade.ArticleDTO;
import com.github.serenity.steps.weltrade.LegalInformationSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.List;

public class LegalInformationScenario {

    @Steps
    private LegalInformationSteps legalInformationSteps;

    @Given("user opened site '$url'")
    public void openLegalInformationPage(final String url) {
        legalInformationSteps.openPageByUrl(url);
    }

    @When("user retrieved all articles to list with site")
    public void retrievedAllArticles() {

        final List<ArticleDTO> expectedAllArticles = legalInformationSteps.getAllArticles();
        Serenity.setSessionVariable("expected_all_articles").to(expectedAllArticles);
        System.out.println(expectedAllArticles);
    }

}
