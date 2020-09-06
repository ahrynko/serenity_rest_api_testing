package com.github.jbehave.scenarionsteps.api.weltrade;

import com.github.logging.Logger;
import com.github.serenity.steps.api.weltrade.ApiFunctionaityWeltradeSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

public class ApiFunctionaityWeltradeScenario {

    @Steps
    private ApiFunctionaityWeltradeSteps testSteps;

    @Given("I perform 'POST' operation using API to WELTARDE")
    public void getRestRequest() {

        final String calcProfitList = testSteps.getCalcProfitInfoFromApi();

        Logger.out.info("Result action: " + calcProfitList);

    }
}
