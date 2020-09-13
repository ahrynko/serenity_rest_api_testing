package com.github.jbehave.scenarionsteps.api.weltrade;

        import com.github.logging.Logger;
        import com.github.page_object.model.weltrade.ArticleDTO;
        import com.github.serenity.steps.api.weltrade.ApiFunctionaityWeltradeSteps;
        import com.github.web_services.weltrade.Document;
        import net.serenitybdd.core.Serenity;
        import net.thucydides.core.annotations.Steps;
        import org.jbehave.core.annotations.Given;
        import org.jbehave.core.annotations.When;

        import java.util.List;

public class ApiFunctionalityWeltradeScenario {

    @Steps
    private ApiFunctionaityWeltradeSteps testSteps;

    @Given("I perform 'POST' operation using API to WELTARDE")
    public void getRestRequest() {

        final String calcProfitList = testSteps.getCalcProfitInfoFromApi();

        Logger.out.info("Result action: " + calcProfitList);

    }

    @When("user executed Rest Request with all articles")
    public void getRestRequestWithAllArticles() {

        final List<Document> actualArticleList = testSteps.retrieveArticlesFromApi();
        Serenity.setSessionVariable("actual_article_list").to(actualArticleList);
    }
}
