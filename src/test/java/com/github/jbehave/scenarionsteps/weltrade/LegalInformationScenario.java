package com.github.jbehave.scenarionsteps.weltrade;

import com.github.logging.Logger;
import com.github.page_object.model.weltrade.ArticleDTO;
import com.github.serenity.steps.weltrade.LegalInformationSteps;
import com.github.web_services.weltrade.Document;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;
import java.util.stream.Collectors;

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
        Serenity.setSessionVariable("expected_article_list").to(expectedAllArticles);
    }

    @Then("compared two List with site and Rest Request")
    public void verifyCompareLists() {

        final List<ArticleDTO> expectedArticleList = Serenity.sessionVariableCalled("expected_article_list");
        final List<Document> actualArticleList = Serenity.sessionVariableCalled("actual_article_list");

        actualArticleList.stream().map(articles -> {  // преобраз. одного сосотояния в другое
            String title = articles.getData().get(0).getSection_articles_array().get(0).getTitle();
            String body = articles.getData().get(0).getSection_articles_array().get(0).getContent();

            return new Document(title, body);  //ref
        }).collect(Collectors.toList());

        Logger.out.info(expectedArticleList.size());

        ReflectionAssert.assertReflectionEquals("There is incorrect articles displayed!",
                expectedArticleList , actualArticleList );

    }

}
