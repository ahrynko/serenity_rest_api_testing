package com.github.jbehave.scenarionsteps.api.weltrade;

import com.github.logging.Logger;
import com.github.serenity.steps.api.weltrade.ApiFunctionaityWeltradeSteps;
import com.github.web_services.weltrade.legal.Document;
import com.github.web_services.weltrade.quotes.RestTemplate;
import com.github.web_services.weltrade.seminars.Seminars;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.Collections;
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

    @Given("I perform 'POST' operation using API to events")
    public void getRestRequestMeetUp() {

        final List<Seminars> actualMeetUpList = testSteps.getMeetUpList();

        final List<Seminars.MeetUps> meetUpsList = actualMeetUpList.listIterator().next().getData().getMeetUps();

        meetUpsList.forEach(meetUp -> Logger.out.info(String.format("** [Text Title] ** %s\n",
                meetUp.getTitle())));
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

        final List<String> items = actualQuotesList.lines().map(item -> {
            List<String> symbol = Collections
                    .singletonList(item.replaceAll("\\[", "")
                    .replace("quotes", "")
                    .replaceAll("\\]", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));

            return String.valueOf(symbol);
        }).collect(Collectors.toList());

        Logger.out.info("Result quotes_2: " + items.listIterator().next());

    }

}
