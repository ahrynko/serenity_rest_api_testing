package com.github.jbehave.scenarionsteps.api.weltrade;

import com.github.logging.Logger;
import com.github.page_object.model.weltrade.ArticleDTO;
import com.github.serenity.steps.api.weltrade.ApiFunctionaityWeltradeSteps;
import com.github.web_services.weltrade.legal.Document;
import com.github.web_services.weltrade.quotes.Export;
import com.github.web_services.weltrade.quotes.RestTemplate;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @When("user executed Rest Request with the same quotes.json")
    public void getRestRequestWithAllQuotes() {

        RestTemplate restTemplate = new RestTemplate();
        final String actualQuotesList = restTemplate.retrieveQuotesFromApi();
        Serenity.setSessionVariable("actual_quotes_list").to(actualQuotesList);

        Logger.out.info("Result quotes: " + actualQuotesList);

      /*  List<String> items = Arrays.asList(actualQuotesList.split("\\s*,\\s*"));
        String [] items2 = actualQuotesList.split("\\s*,\\s*");

        final List<Export> items1 = actualQuotesList.lines().map(item -> {
            String symbol = item.replaceAll("quotes","").trim();
            return new Export(symbol);
        }).collect(Collectors.toList());
        Logger.out.info("Result quotes: " + items1.listIterator().next().getCurrency_pair());*/
    }

}
