package com.github.jbehave.scenarionsteps.weltrade;

import com.github.common.data.EnvironmentProperties;
import com.github.logging.Logger;
import com.github.page_object.model.weltrade.InstrumentsDTO;
import com.github.serenity.steps.weltrade.PartnerRemunerationSteps;
import com.github.web_services.weltrade.conditions.Instruments;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Then("compared two List of GBPUSD Instruments with site and Rest Request")
    public void verifyCompare2Lists() {

        final List<InstrumentsDTO> expectedInstruments = Serenity.sessionVariableCalled("expected_instruments_list"); //site
        final List<Instruments> actualInstruments = Serenity.sessionVariableCalled("actual_instruments_list"); //api

        Logger.out.info(expectedInstruments.size()); //54
        Logger.out.info(actualInstruments.size());  //1

        final List<InstrumentsDTO> expectedGbpUsd = expectedInstruments.subList(1,2);  //GBPUSD with site


        final List<Instruments.Micro> articlesArray = actualInstruments.listIterator().next()
                .getData().getLevelOne().getStandard().getMicro();

        final List<InstrumentsDTO> actualGbpUsd = articlesArray.stream().map(instruments -> {  //GBPUSD via api
            String instrument = instruments.getGbpusd().getClass().getSimpleName().toUpperCase();
            String spread = instruments.getGbpusd().getSpread();
            String points = instruments.getGbpusd().getLevel1().getVolume().replaceAll("00","").trim();
            String usd = instruments.getGbpusd().getLevel1().getUsd().replaceAll("00","").trim();
            String mtp = instruments.getGbpusd().getMtp().trim();

            return new InstrumentsDTO(instrument,spread,points,usd,mtp);
        }).collect(Collectors.toList());


        ReflectionAssert.assertReflectionEquals("There is incorrect GBPUSD instrument displayed!",
                expectedGbpUsd , actualGbpUsd );

    }
}
