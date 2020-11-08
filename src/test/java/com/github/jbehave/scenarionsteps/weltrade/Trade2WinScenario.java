package com.github.jbehave.scenarionsteps.weltrade;

import com.github.common.data.EnvironmentProperties;
import com.github.logging.Logger;
import com.github.page_object.model.weltrade.WinnersDrawDTO;
import com.github.serenity.steps.weltrade.Trade2WinSteps;
import com.github.web_services.weltrade.trade2win.LastWinners;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Trade2WinScenario {

    @Steps
    private Trade2WinSteps trade2WinSteps;

    @Given("user opened 'promotions/trade2win' by url: '$url'")
    public void openPartnerRemunerationPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        trade2WinSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user retrieved last current winners to list with site")
    public void retrievedCurrentWinners() {
        trade2WinSteps.openModalLastWinners();
        final List<WinnersDrawDTO> expectedLastWinnersList = trade2WinSteps.getCurrentWinners();

        Serenity.setSessionVariable("expected_last_winners_list").to(expectedLastWinnersList);
    }

    @Then("compared two List of last winners with site and Rest Api Request")
    public void verifyCompareLastWinnersLists() {

        final List<WinnersDrawDTO> expectedLastWinners = Serenity.sessionVariableCalled("expected_last_winners_list"); //site
        final List<LastWinners> actualLastWinners = Serenity.sessionVariableCalled("actual_last_winners_list"); //api

        final List<LastWinners.Winners> lastWinnersArray = actualLastWinners.listIterator().next()
                .getData().getHistory().listIterator(0).next().getWinners();  //last[0,1,2,3]

        final List<WinnersDrawDTO> collectActualLastWinners = lastWinnersArray.stream().map(winners -> {
            String place = winners.getPlace();
            String country = winners.getCountry();
            String userId = winners.getProfileID();
            String amount = winners.getSumPrize();

            return new WinnersDrawDTO(place, country, userId, amount);
        }).collect(Collectors.toList());

        Logger.out.info(expectedLastWinners.size());
        Logger.out.info(collectActualLastWinners.size());

        ReflectionAssert.assertReflectionEquals("There is incorrect last winners displayed!",
                expectedLastWinners , collectActualLastWinners );

    }

}

