package com.github.serenity.steps.weltrade;

import com.github.common.data.UrlBuilder;
import com.github.page_object.model.weltrade.WinnersDrawDTO;
import com.github.page_object.pages.weltrade.Trade2WinPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class Trade2WinSteps extends ScenarioSteps {

    private Trade2WinPage trade2WinPage;

    public Trade2WinSteps(final Pages pages) { //create page object
        this.trade2WinPage = pages.getPage(Trade2WinPage.class); //pages - initialized page object
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, Trade2WinPage.class);
        trade2WinPage.openUrl(fullNavUrl);
    }

    @Step
    public void openModalLastWinners() {
        trade2WinPage.openModalLastWinners();
    }

    @Step
    public List<WinnersDrawDTO> getCurrentWinners() {
        return trade2WinPage.getCurrentWinnersUsingStreamApi();
    }
}
