package com.github.jbehave.scenarionsteps.weltrade;

import com.github.common.data.EnvironmentProperties;
import com.github.logging.Logger;
import com.github.page_object.model.weltrade.QuotesDTO;
import com.github.serenity.steps.weltrade.CurrencyQuotesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.List;

public class CurrencyQuotesScenario {

    @Steps
    private CurrencyQuotesSteps currencyQuotesSteps;

    @Given("user opened 'Currency Quotes Page' by url: '$url'")
    public void openCurrencyQuotesPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        currencyQuotesSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user retrieved quotes to list with site")
    public void retrievedItemList() {

        final List<QuotesDTO> expectedQuotesList = currencyQuotesSteps.getQuotesItems();
        Serenity.setSessionVariable("expected_quotes_list").to(expectedQuotesList);

        Logger.out.info(expectedQuotesList.size());
    }

}
