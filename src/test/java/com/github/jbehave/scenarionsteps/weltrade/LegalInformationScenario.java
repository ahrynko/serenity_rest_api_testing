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

        final List<Document.ArticlesParam> articlesArray = actualArticleList.listIterator().next()
                .getData().listIterator().next().getSection_articles_array();

        final List<ArticleDTO> collectActualArticleList = articlesArray.stream().map(articles -> {
            String title = articles.getTitle().replaceAll("<p>","").replaceAll("</p>","").trim();
            String body = articles.getContent().replaceAll("<p>","").replaceAll("</p>","").trim();

            return new ArticleDTO(title, body);
        }).collect(Collectors.toList());


        Logger.out.info(expectedArticleList.size());
        Logger.out.info(collectActualArticleList.size());

        ReflectionAssert.assertReflectionEquals("There is incorrect articles displayed!",
                expectedArticleList , collectActualArticleList );

    }

}
