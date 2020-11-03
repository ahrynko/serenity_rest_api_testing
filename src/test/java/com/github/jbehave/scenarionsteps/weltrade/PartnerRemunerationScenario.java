package com.github.jbehave.scenarionsteps.weltrade;

import com.github.common.data.EnvironmentProperties;
import com.github.logging.Logger;
import com.github.page_object.model.weltrade.InstrumentsDTO;
import com.github.serenity.steps.weltrade.PartnerRemunerationSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.List;

public class PartnerRemunerationScenario {

    @Steps
    private PartnerRemunerationSteps partnerRemunerationSteps;

    @Given("user opened 'Partner Remuneration' by url: '$url'")
    public void openPartnerRemunerationPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        partnerRemunerationSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user retrieved instruments to list with site")
    public void retrievedInstruments() {

        final List<InstrumentsDTO> expectedInstrumentsList = partnerRemunerationSteps.getInstruments();
        Serenity.setSessionVariable("expected_instruments_list").to(expectedInstrumentsList);

        Logger.out.info(expectedInstrumentsList.size());
    }
}
